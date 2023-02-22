package com.example.hobbyhopper.services;

import org.springframework.stereotype.Service;



@Service
public class StringService {
    public String capitalizeWord(String word){
        if(word.length() > 30 ){
            return  word.substring(0, 1).toUpperCase() + word.substring(1,25).toLowerCase() + "...";
        } else {
            return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
        }
    }

    public String limitLength(String string, int limit) {
        if(limit > string.length()) return string;

        return string.substring(0, limit).substring(0,1).toUpperCase() + string.substring(1,6).toLowerCase() + "...";
    }

    public String limitLengthBig(String string, int limit) {
        if(limit > string.length()) return string;

        return string.substring(0, limit).substring(0,1).toUpperCase() + string.substring(1,10).toLowerCase() + "...";
    }
}
