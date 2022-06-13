package com.example.hobbyhopper.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class KeysController {
    @Value("${token}")
    private String token;

    @Value("${FILESTACK_API_TOKEN}")
    private String FILESTACK_API_TOKEN;

    @Value("${MAPBOX_API_TOKEN}")
    private String MAPBOX_API_TOKEN;

    @GetMapping(path="/keys", produces ="application/javascript")
    @ResponseBody
    public String keys(){
        String rawg="const token='"+token+"';";
        rawg+="const MAPBOX_API_TOKEN'"+MAPBOX_API_TOKEN+"';";
        rawg+="conts FILESTACK_API_TOKEN='"+FILESTACK_API_TOKEN+"';";
        return rawg;
    }
}
