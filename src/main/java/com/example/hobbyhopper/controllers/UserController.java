package com.example.hobbyhopper.controllers;

import com.example.hobbyhopper.models.User;
import com.example.hobbyhopper.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    private UserRepository userDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user",new User());
        return "views/sign-up";
    }

    @PostMapping("/sign-up")
    public String postUser(@ModelAttribute User user){

//        if(user.getUsername().length() < 3 || user.getPassword().length() < 8 || user.getEmail().isEmpty()){
//            validation.addError(new FieldError("user", "username", "Username Error"));
//            validation.addError(new FieldError("user", "email", "Email Error"));
//            validation.addError(new FieldError("user", "password", "Password Error"));
//            if(validation.hasErrors()){
//                model.addAttribute("errors", validation);
//                model.addAttribute("user", user);
//                return "views/sign-up";
//            }
//        }

        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/sign-up";
    }
}
