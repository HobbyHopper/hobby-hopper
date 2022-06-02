package com.example.hobbyhopper.controllers;

import com.example.hobbyhopper.models.Event;
import com.example.hobbyhopper.models.User;
import com.example.hobbyhopper.models.UserEvent;
import com.example.hobbyhopper.repositories.EventRepository;
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


    public EventController(EventRepository eventDao, UserRepository userDao) {
        this.eventDao = eventDao;
        this.userDao = userDao;
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
//        add expertise to constructor
        model.addAttribute("userEvent",new UserEvent());

        return "views/create-edit-event";
    }
    @PostMapping("/create")
    public String createEvent(@ModelAttribute Event event, @ModelAttribute UserEvent userEvent){
        User user= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        when creating a new event also sets the owner on UserEvent row and ties the two together
//        event.set
        userEvent.setUser(user);
        userEvent.setEvent(event);
        userEvent.setOwner(true);

        return "views/individual-event";
    }



}
