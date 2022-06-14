package com.example.hobbyhopper.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String landingPage(){
        return "views/landing";
    }

    @GetMapping("about")
    public String aboutUsPage(){
        return "views/about";
    }

}
