package com.example.hobbyhopper.controllers;

import com.example.hobbyhopper.models.Event;
import com.example.hobbyhopper.repositories.EventRepository;
import com.example.hobbyhopper.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/event")
public class EventController {
    private final EventRepository eventDao;
    private final UserRepository userDao;


    public EventController(EventRepository eventDao, UserRepository userDao) {
        this.eventDao = eventDao;
        this.userDao = userDao;
    }

    @GetMapping("/{id}")
    public String individualEvent(@PathVariable long id, Model model){
        Event event= eventDao.getById(id);

        model.addAttribute("event",event);
        return "views/individual-event";

    }
}
