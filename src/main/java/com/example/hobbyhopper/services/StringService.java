package com.example.hobbyhopper.services;

import org.springframework.stereotype.Service;



@Service
public class StringService {
    public String capitalizeWord(String word){
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }
}
