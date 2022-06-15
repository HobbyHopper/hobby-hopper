package com.example.hobbyhopper.controllers;

import com.example.hobbyhopper.models.*;
import com.example.hobbyhopper.repositories.*;
import com.example.hobbyhopper.services.EventService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/event")
public class EventController {
    private final EventRepository eventDao;
    private final UserRepository userDao;
    private final UserEventRepository userEventDao;
    private final ExpertiseRepository expertiseDao;
    private final HobbiesRepository hobbyDao;
    private final CategoryController categoryDao;
    private final ImageRepository imageDao;
    private final EventService eventService = new EventService();


    public EventController(EventRepository eventDao, UserRepository userDao, UserEventRepository userEventDao, ExpertiseRepository expertiseDao, HobbiesRepository hobbyDao, CategoryController categoryDao, ImageRepository imageDao) {
        this.eventDao = eventDao;
        this.userDao = userDao;
        this.userEventDao = userEventDao;
        this.expertiseDao = expertiseDao;
        this.hobbyDao = hobbyDao;
        this.categoryDao = categoryDao;
        this.imageDao = imageDao;
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
        model.addAttribute("EventService", eventService);

        Event event = eventDao.getById(id);
        model.addAttribute("event", event);

        String startDateMonth = eventService.getMonthString( event.getStartDate().getMonth() + 1 );
        model.addAttribute("startDateMonth", startDateMonth);

        String endDateMonth = eventService.getMonthString( event.getEndDate().getMonth() + 1 );
        model.addAttribute("endDateMonth", endDateMonth);

        Category category = categoryDao.getById((long) event.getCategoryId());
        model.addAttribute("category", category);

        //if user is logged in...
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser"){
            User userAccess = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = userDao.getById(userAccess.getId());
            UserEvent userIsOwner = userEventDao.findByEventAndUserAndIsOwner(event, user, true);
            UserEvent userHasRSVPd = userEventDao.findByEventAndUserAndIsOwnerFalse(event, user);
            //if user is owner of event, add model attribute
            if (userIsOwner != null) model.addAttribute("userIsOwner", userIsOwner);
            //if user is not owner and user is rsvp'd to the event, add model attribute
            if (userIsOwner == null && userHasRSVPd != null) model.addAttribute("userHasRSVPd", userHasRSVPd);
        }

        List<Image> images = event.getEventImages();
        if (images != null) {
            model.addAttribute("images", images);
        }



        return "views/individual-event";

    }

    @GetMapping("/create-edit-event")
    public String showCreateForm(Model model) {
        User userAccess = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userDao.getById(userAccess.getId());

        System.out.println(userAccess.getId());

        List<Hobby> userHobbies = user.getUserHobbies();

        model.addAttribute("userHobbies", userHobbies);

        model.addAttribute("event", new Event());

        return "views/create-edit-event";
    }

    @GetMapping("/edit/{id}")
    public String editPost(@PathVariable long id, Model model) {
        User userAccess = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.getById(userAccess.getId());
        Event event = eventDao.getById(id);
        List<Image> images = event.getEventImages();
        if (images != null) {
            model.addAttribute("images", images);
        }
        UserEvent userEvent = userEventDao.findByEventAndUserAndIsOwner(event, user, true);
        if (userEvent != null) {
            model.addAttribute("event", event);
            return "views/create-edit-event";
        } else {
            return "redirect:/event/create-edit-event";
        }

    }

    @PostMapping("/edit/{id}")
    public String updatePost(@RequestParam(name="images", required = false) List<String> imageUrl, @PathVariable long id, @ModelAttribute Event event){
        List<Image> imageList = new ArrayList<>();
        List<Image> eventImages = event.getEventImages();

        eventDao.save(event);

        if(event.getEventImages() == null){
            eventImages = imageList;
        }
            for(String url: imageUrl){
                Image image = new Image(url, event);
                eventImages.add(image);
            }
            event.setEventImages(eventImages);

            eventDao.save(event);

        return "redirect:/event/" + event.getId();
    }

    @PostMapping("/delete-image")
    public String deleteImage(@RequestParam(name="id") long id, Model model){
        Image image = imageDao.getById(id);
        Event event = image.getEvent();

        model.addAttribute("event", event);

        imageDao.deleteById(id);

        return "redirect:/event/edit/" + event.getId();
    }


    @PostMapping("/create")
    public String createEvent(@ModelAttribute Event event, @RequestParam(name="expertise") long expertiseId, @RequestParam(name="images", required = false) List<String> imageUrl, @RequestParam(name="hobbies") List<Long> hobbyIds){
        User userAccess = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userDao.getById(userAccess.getId());

        Event myEvent= eventDao.save(event);

        UserEvent userEvent=new UserEvent(expertiseDao.getById(expertiseId));
        userEvent.setUser(user);
        userEvent.setEvent(myEvent);
        userEvent.setOwner(true);
        userEventDao.save(userEvent);

        List<Hobby> eventHobbies = new ArrayList<>();

        for (long hobbyId : hobbyIds) {
            Hobby hobby = hobbyDao.getById(hobbyId);
            eventHobbies.add(hobby);
        }
        event.setEventHobbies(eventHobbies);

        List<Image> eventImages = event.getEventImages();
        List<Image> imageList = new ArrayList<>();

        if(event.getEventImages() == null){
            return "redirect:/event/create?image";
        }
        for(String url: imageUrl){
            Image image = new Image(url, event);
            eventImages.add(image);
        }
        event.setEventImages(eventImages);

        eventDao.save(event);

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
    public String searchEvents(@RequestParam(name = "search") String search, Model model) {
//        Get all events
        List<Event> allEvents=eventDao.findAll();
//        search all events by title and store them
        List<Event> eventsByTitle = eventDao.searchByTitleLike(search);
//        Create empty event list to hold all events linked to a hobby name search
        List<Event> eventsByHobby=new ArrayList<>();
//        Create empty event list to hold all events linked by category name search
        List<Event> eventsByCategory=new ArrayList<>();
//        combine all search results into one list
        List<Event> searchEvents=new ArrayList<>();
//       store all hobbies/categories with name matching query in a list
        List<Hobby> hobbyList = hobbyDao.searchByNameLike(search);
        List<Category> categoryList= categoryDao.searchByNameLike(search);

//  loop through events and find all events associated with similar hobby names
        for(Event event:allEvents) {
            if (event.getEventHobbies() != null) {
                List<Hobby> eventHobbies = event.getEventHobbies();
                for (Hobby hobbySearch : hobbyList) {
                    for (Hobby hobby : eventHobbies) {
                        if (hobbySearch.getHobbyName().equals(hobby.getHobbyName())) {
                            eventsByHobby.add(event);
                            searchEvents.add(event);
                        }
                    }
                }
            }
        }
         for(Event event:allEvents)  {
             for(Category categorySearch:categoryList){
                 if(event.getCategoryId()==categorySearch.getId()){
                     eventsByCategory.add(event);
                     searchEvents.add(event);
                 }
             }
         }
         for (Event event:eventsByTitle){
             searchEvents.add(event);
         }

//         confirm search category works
//        for(Category category:categoryList){
//            System.out.println(category);
//        }

//            confirm event by title works
//        for (Event event : eventsByTitle) {
//           System.out.println(event.getId());
//        }

//        confirm search by similar hobbies works
//        for (Event event:eventsByHobby){
//            System.out.println(event.getId());
//        }
//        Confirm search hobby works
//        for (Hobby hobby : hobbyList) {
//            System.out.println(hobby.getHobbyName());
//        }
        model.addAttribute("searchEvents",searchEvents);
        model.addAttribute("eventsByTitle",eventsByTitle);
        model.addAttribute("eventsByCategory",eventsByCategory);
        model.addAttribute("eventsByHobby",eventsByHobby);


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
