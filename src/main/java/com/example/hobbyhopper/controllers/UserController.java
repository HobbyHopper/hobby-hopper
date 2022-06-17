package com.example.hobbyhopper.controllers;

import com.example.hobbyhopper.models.Event;
import com.example.hobbyhopper.models.Hobby;
import com.example.hobbyhopper.models.User;
import com.example.hobbyhopper.models.UserEvent;
import com.example.hobbyhopper.repositories.EventRepository;
import com.example.hobbyhopper.repositories.HobbiesRepository;
import com.example.hobbyhopper.repositories.UserEventRepository;
import com.example.hobbyhopper.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    private final UserRepository userDao;
    private final PasswordEncoder passwordEncoder;
    private final HobbiesRepository hobbyDao;
    private final UserEventRepository userEventDao;
    private final EventRepository eventDao;


    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder, HobbiesRepository hobbyDao, UserEventRepository userEventDao, EventRepository eventDao) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.hobbyDao = hobbyDao;
        this.userEventDao = userEventDao;
        this.eventDao = eventDao;
    }

    @GetMapping("/profile")
    public String showProfile(Model model) {
        User userAccess = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.getById(userAccess.getId());
        List<Hobby> userHobbies = new ArrayList<>();
        List<Event> createdEvents = new ArrayList<>();
        List<Event> userRsvpEvents = new ArrayList<>();
        List<UserEvent> isOwnerUserEvents = userEventDao.findAllByUserAndIsOwner(user, true);
        List<UserEvent> isNotOwnerUserEvents = userEventDao.findAllByUserAndIsOwner(user, false);

        Date today = new Date();

        if (user.getUserHobbies() != null) {
            userHobbies = user.getUserHobbies();
        }
        model.addAttribute("userHobbies", userHobbies);


        if (isOwnerUserEvents.size() != 0) {
            for (UserEvent userEvent : isOwnerUserEvents) {
                Event userCreatedEvent = eventDao.findByUserEvents(userEvent);
                if (today.before(userCreatedEvent.getEndDate())) {
                    createdEvents.add(userCreatedEvent);
                    if (createdEvents.size() == 3) {
                        break;
                    }
                }
            }
            if (createdEvents.size()!=0) {
                createdEvents.sort(Comparator.comparing(Event::getStartDate));
                model.addAttribute("createdEvents", createdEvents);
            }
        }
        if (isNotOwnerUserEvents.size() != 0) {
            for (UserEvent userEvent : isNotOwnerUserEvents) {
                Event userRsvpEvent = eventDao.findByUserEvents(userEvent);
                if (today.before(userRsvpEvent.getEndDate())) {
                    userRsvpEvents.add(userRsvpEvent);
                }
                if (userRsvpEvents.size() == 3) {
                    break;
                }
            }
            if (userRsvpEvents.size()!=0) {
                userRsvpEvents.sort(Comparator.comparing(Event::getEndDate));
                model.addAttribute("userRsvpEvents", userRsvpEvents);
            }
        }


        model.addAttribute("hobby", new Hobby());
        return "views/profile";
    }

    @PostMapping("/add-hobbies")
    public String addHobbies(@ModelAttribute Hobby hobby) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User hobbyUser = userDao.getById(user.getId());

        if (hobbyDao.existsByHobbyNameIgnoreCase(hobby.getHobbyName())) {
            hobby = hobbyDao.findByHobbyName(hobby.getHobbyName());
        }

        if (hobbyDao.existsByUsersAndHobbyNameIgnoreCase(hobbyUser, hobby.getHobbyName())) {
            return "redirect:/profile";
        }

        if (hobbyUser.getUserHobbies() != null) {
            hobbyUser.getUserHobbies().add(hobby);
        } else {
            List<Hobby> hobbies = new ArrayList<>();
            hobbies.add(hobby);
            hobbyUser.setUserHobbies(hobbies);
        }


        hobbyDao.save(hobby);
        return "redirect:/profile";
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "views/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@Valid @ModelAttribute User user, BindingResult validation, Model model, @RequestParam(name = "images", required = false) String images) {

        if (userDao.existsByUsername(user.getUsername()) || userDao.existsByEmail(user.getEmail())) {
            validation.addError(new FieldError("user", "username", "Username or email is taken"));
        }

        if (user.getUsername().length() < 3) {
            validation.addError(new FieldError("user", "username", "Username needs to be at least 3 characters long"));
        }
        if (user.getEmail().isEmpty()) {
            validation.addError(new FieldError("user", "email", "Email cannot be empty"));
        }
        if (user.getPassword().length() < 8) {
            validation.addError(new FieldError("user", "password", "Password needs to be 8 characters long"));
        }

        if (!user.getPassword().equals(user.getConfirm())) {
            validation.addError(new FieldError("user", "confirm", "Password mismatch"));
        }
        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("user", user);
            return "views/sign-up";
        }

        user.setImage(images);
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);

        return "redirect:/login?account";
    }

    @GetMapping("/user/update")
    public String showUpdateForm(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", userDao.findById(user.getId()));
        return "views/edit-user-info";
    }

    @PostMapping("/user/update")
    public String updateTheForm(@Valid @ModelAttribute User user, BindingResult validation, Model model, HttpSession session, @RequestParam(name = "images", required = false) String images) {
        User userInfoPull = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User editUser = userDao.getById(userInfoPull.getId());

        editUser.setUsername(user.getUsername());
        editUser.setEmail(user.getEmail());
        editUser.setImage(images);
        editUser.setLocation(user.getLocation());
        String hash = passwordEncoder.encode(user.getPassword());
        editUser.setPassword(hash);

        if (user.getUsername().isEmpty()) {
            validation.addError(new FieldError("user", "username", "Username cannot be empty"));
        }

        if (user.getEmail().isEmpty()) {
            validation.addError(new FieldError("user", "email", "Email cannot be empty"));
        }


        if(!user.getPassword().equals(user.getConfirm()) || user.getPassword().isEmpty()){
            validation.addError(new FieldError("user", "confirm", "Password mismatch"));
        }

        if (userDao.existsByUsername(user.getUsername()) && !userInfoPull.getUsername().equals(editUser.getUsername())) {
            validation.addError(new FieldError("user", "username", "Username is already taken"));
        }

        if (userDao.existsByEmail(user.getEmail()) && !userInfoPull.getEmail().equals(editUser.getEmail())) {
            validation.addError(new FieldError("user", "email", "Email is already taken"));
        }

        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("user", user);
            return "views/edit-user-info";
        } else {
            userDao.save(editUser);
        }

        session.invalidate();
        return "redirect:/login?updated";
    }

    @GetMapping("/user/delete")
    public String deleteButton(@Valid @ModelAttribute User user, HttpSession session) {
        User userInfoPull = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User deleteUser = userDao.getById(userInfoPull.getId());
        List <Hobby> userHobbies= deleteUser.getUserHobbies();
        userHobbies.removeAll(hobbyDao.findAll());
        userDao.delete(deleteUser);
        session.invalidate();

        return "redirect:/event?deleted";
    }


    @GetMapping("/login")
    public String showLogin() {
        return "views/login";
    }

    @GetMapping("user/delete-hobby/{id}")
    public String deleteUserHobby(@PathVariable long id) {
        User userAccess = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.getById(userAccess.getId());
        List<Hobby> userHobbies = user.getUserHobbies();

        userHobbies.removeIf(hobby -> hobby.getId() == id);
        user.setUserHobbies(userHobbies);
        userDao.save(user);
        return "redirect:/profile";
    }
}

