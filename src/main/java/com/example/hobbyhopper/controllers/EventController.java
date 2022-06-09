package com.example.hobbyhopper.controllers;

import com.example.hobbyhopper.models.*;
import com.example.hobbyhopper.repositories.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {
    private final EventRepository eventDao;
    private final UserRepository userDao;
    private final UserEventRepository userEventDao;
    private final ExpertiseRepository expertiseDao;
    private final HobbiesRepository hobbyDao;


    public EventController(EventRepository eventDao, UserRepository userDao, UserEventRepository userEventDao, ExpertiseRepository expertiseDao,  HobbiesRepository hobbyDao) {
        this.eventDao = eventDao;
        this.userDao = userDao;
        this.userEventDao = userEventDao;
        this.expertiseDao = expertiseDao;
        this.hobbyDao = hobbyDao;
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

        Event event = eventDao.getById(id);
        model.addAttribute("event", event);

        //if there is a user logged in, and they are the owner of the event, add the "userIsOwner" attribute to the model in order to allow certain functionality like edit and delete to the event view
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser"){

            User userAccess = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = userDao.getById(userAccess.getId());
            UserEvent userIsOwner = userEventDao.findByEventAndUserAndIsOwner(event, user, true);

            if (userIsOwner != null) {
                model.addAttribute("userIsOwner", userIsOwner);
            }
        }

        List<Image> images = event.getEventImages();
        if (images != null) {
            model.addAttribute("images", images);
        }

        return "views/individual-event";

    }

    @GetMapping("/create-edit-event")
    public String showCreateForm(Model model) {
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
    public String createEvent(@ModelAttribute Event event, @RequestParam(name="expertise") long expertiseId){
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
    public String rsvpToEvent(@RequestParam ("event-id") long eventId, @RequestParam ("expertise") long expertiseId){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Event event = eventDao.getById(eventId);
        Expertise expertise = expertiseDao.getById(expertiseId);
        UserEvent userEvent = new UserEvent(user, event, false, expertise);
        userEventDao.save(userEvent);

        return "redirect:/event/"+eventId;
    }

    @PostMapping("/report")
    public String reportEvent(@RequestParam ("event-id") long eventId, Model model){
        Event event = eventDao.getById(eventId); //gets event with the event-id parameter sent from the view
        event.setReported(true); //changes event reported status
        eventDao.save(event);  //saves event
        return "redirect:/event/" + event.getId();//redirects user to the same post that was reported
    }

    @GetMapping("/search")
    public String searchEvents(@RequestParam(name = "search") String search) {
//        Get all events
        List<Event> allEvents=eventDao.findAll();
//        search all events by title and store them
        List<Event> eventsByTitle = eventDao.searchByTitleLike(search);
//        Create empty event list to hold all events linked to a hobby
        List<Event> hobbyEvents=new ArrayList<>();
//confirm event by title works
        for (Event event : eventsByTitle) {
            System.out.println(event.getId());
        }
//       store all hobbies with name matching query in a list
        List<Hobby> hobbyList = hobbyDao.searchByNameLike(search);
//        Confirm search hobby works
        for (Hobby hobby : hobbyList) {
            System.out.println(hobby.getHobbyName());
        }

        for(Event event:allEvents){
            if(event.getEventHobbies()!= null){
                List<Hobby> eventHobbies=event.getEventHobbies();
                for (Hobby hobbySearch:hobbyList){
                    for(Hobby hobby:eventHobbies){
                     if (hobbySearch.getHobbyName().equals(hobby.getHobbyName())) {
                         hobbyEvents.add(event);
                     }
                    }
                }
            }
        }
        for (Event event:hobbyEvents){
            System.out.println(event.getId());
        }



        return "views/search";
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable long id){

        //if statement below validates that there is a user logged in
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {

            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            System.out.println(user);
            Event event = eventDao.getById(id);
            System.out.println(event);
            UserEvent userEvent = userEventDao.findByEventAndUserAndIsOwner(event, user, true);
            System.out.println(userEvent);

            //if statement below validates that the user of the event is the owner
            if (userEvent != null) {
                eventDao.delete(event);
            }
        }

        return "views/index";

    }



}
