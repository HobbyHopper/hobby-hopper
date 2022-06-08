package com.example.hobbyhopper.controllers;

import com.example.hobbyhopper.models.*;
import com.example.hobbyhopper.repositories.EventRepository;
import com.example.hobbyhopper.repositories.ExpertiseRepository;
import com.example.hobbyhopper.repositories.UserEventRepository;
import com.example.hobbyhopper.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {
    private final EventRepository eventDao;
    private final UserRepository userDao;
    private final UserEventRepository userEventDao;
    private final ExpertiseRepository expertiseDao;


    public EventController(EventRepository eventDao, UserRepository userDao, UserEventRepository userEventDao, ExpertiseRepository expertiseDao) {
        this.eventDao = eventDao;
        this.userDao = userDao;
        this.userEventDao = userEventDao;
        this.expertiseDao = expertiseDao;
    }

    @GetMapping()
    public String showLandingEvents(Model model) {
//pulls all events to show at landing page if the user is logged ing
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
            List<Event> events = eventDao.findAll();
            model.addAttribute("events", events);
            System.out.println(events);}
//        if user is anonymous it will show only public event
        else  {
            List <Event> events=eventDao.findAllByIsPublic(true);
            model.addAttribute("events", events);
        }

        return "views/index";
    }

    @GetMapping("/{id}")
    public String individualEvent(@PathVariable long id, Model model) {

        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Event event = eventDao.getById(id);

        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser"){

            User userAccess = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = userDao.getById(userAccess.getId());
            UserEvent userIsOwner = userEventDao.findByEventAndUserAndIsOwner(event, user, true);

            if (userIsOwner != null) {
                model.addAttribute("userIsOwner", userIsOwner);
            }
        }

        //pulls one event by "id" to display at individual event page
        model.addAttribute("event", event);

        List<Image> images = event.getEventImages();
        if (images != null) {
            model.addAttribute("images", images);
        }

        return "views/individual-event";

    }

    @GetMapping("/create-edit-event")
    public String showCreateForm(Model model) {
//     sends to create page and uses form model binding for creating a new event
        model.addAttribute("event", new Event());

        return "views/create-edit-event";
    }

    @GetMapping("/edit/{id}")
    public String editPost(@PathVariable long id, Model model) {
        User userAccess = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.getById(userAccess.getId());
        Event event = eventDao.getById(id);
        UserEvent userEvent = userEventDao.findByEventAndUserAndIsOwner(event, user, true);
        if (userEvent != null) {
            model.addAttribute("event", event);
            return "views/create-edit-event";
        } else {
            return "redirect:/event/create-edit-event";
        }

    }

    @PostMapping("/edit/{id}")
    public String updatePost(@PathVariable long id, @ModelAttribute Event event){
        eventDao.save(event);

        return "redirect:/event/" + event.getId();
    }

    @PostMapping("/create")
    public String createEvent(@ModelAttribute Event event,@RequestParam(name="expertise") long expertiseId){
        User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Event myEvent= eventDao.save(event);
        UserEvent userEvent=new UserEvent(expertiseDao.getById(expertiseId));
        userEvent.setUser(user);
        userEvent.setEvent(myEvent);
        userEvent.setOwner(true);

        userEventDao.save(userEvent);

        return "redirect:/event/"+event.getId();

    }

    @PostMapping("/rsvp")
    public String rsvpToEvent(@ModelAttribute Event event,@RequestParam ("expertise") long id){
//        get user from session
        User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Access Expertise
        Expertise expertise= expertiseDao.getById(id);
//        create new user event
        UserEvent userEvent=new UserEvent();
//        attach non owner user and event to userEvent
        userEvent.setEvent(event);
        userEvent.setUser(user);
        userEvent.setOwner(false);
        userEvent.setExpertise(expertise);
//        save userEvent
        userEventDao.save(userEvent);
//
        return "views/individual-event";
    }

    @PostMapping("/report")
    public String reportEvent(@ModelAttribute Event event){
//        change event reported status
        event.setReported(true);
//        save event
        eventDao.save(event);
//        redirect to events/search page
        return "views/search";
    }

    @GetMapping("/search")
    public String searchEvents(){
        return"views/search";
    }



}
