package com.example.hobbyhopper.controllers;

import com.example.hobbyhopper.models.*;
import com.example.hobbyhopper.repositories.ImageRepository;
import com.example.hobbyhopper.repositories.UserEventRepository;
import com.example.hobbyhopper.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class EventImagesController {
    private final UserRepository userDao;
    private final ImageRepository imageDao;
    private final UserEventRepository userEventDao;

    public EventImagesController(UserRepository userDao, ImageRepository imageDao, UserEventRepository userEventDao) {
        this.userDao = userDao;
        this.imageDao = imageDao;
        this.userEventDao = userEventDao;
    }


    @GetMapping("/event/image-upload")
    public String showForm(Model model){
        model.addAttribute("image", new Image());
        return "views/event-images";
    }

    @PostMapping("/event-image/{id}")
    public String uploadFiles(@PathVariable long id, @ModelAttribute Image image){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User eventUser = userDao.getById(user.getId());

        List<Image> imageList = new ArrayList<>();

        imageList.add(image);





        return "redirect:/profile";
    }
}
