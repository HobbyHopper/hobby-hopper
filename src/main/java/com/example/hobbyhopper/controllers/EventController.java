package com.example.hobbyhopper.controllers;

import com.example.hobbyhopper.models.Event;
import com.example.hobbyhopper.models.User;
import com.example.hobbyhopper.models.UserEvent;
import com.example.hobbyhopper.repositories.EventRepository;
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


    public EventController(EventRepository eventDao, UserRepository userDao, UserEventRepository userEventDao) {
        this.eventDao = eventDao;
        this.userDao = userDao;
        this.userEventDao = userEventDao;
    }

    @GetMapping()
    public String showLandingEvents(Model model) {
//pulls all events to show at landing page (still need to limit results to "public" events only)
        List<Event> events = eventDao.findAll();
        model.addAttribute("events", events);
        return "views/landing";
    }

    @GetMapping("/{id}")
    public String individualEvent(@PathVariable long id, Model model) {
//        pulls one event by "id" to display at individual events page
        Event event = eventDao.getById(id);

        model.addAttribute("event", event);

        return "views/individual-event";

    }

    @GetMapping("/create-edit-event")
    public String showCreateForm(Model model) {
//     sends to create page and uses form model binding for creating a new event
        model.addAttribute("event", new Event());
//    TODO create new UserEvent *need to add expertise to constructor*
        model.addAttribute("userEvent",new UserEvent());

        return "views/create-edit-event";
    }
    @PostMapping("/create")
    public String createEvent(@ModelAttribute Event event, @ModelAttribute UserEvent userEvent){
//        takes user from session
        User user= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//       attach event and owning user to UserEvent
        userEvent.setUser(user);
        userEvent.setEvent(event);
        userEvent.setOwner(true);
//        save Event and UserEvent
        eventDao.save(event);
        userEventDao.save(userEvent);

//TODO change to id
        return "views/individual-event";
    }

    @PostMapping("/rsvp")
    public String rsvpToEvent(@ModelAttribute Event event){
//        get user from session
        User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        create new user event
        UserEvent userEvent=new UserEvent();
//        attach non owner user and event to userEvent
        userEvent.setEvent(event);
        userEvent.setUser(user);
        userEvent.setOwner(false);
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



}
