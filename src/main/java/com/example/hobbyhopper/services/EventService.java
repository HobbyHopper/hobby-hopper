package com.example.hobbyhopper.services;

import org.springframework.stereotype.Service;

@Service
public class EventService {

    public static String formatTime(String time){

        int firstTwoDigits = Integer.parseInt(time.substring(0,2));
        String lastTwoDigits = time.substring(3);

        if (firstTwoDigits > 12){
            firstTwoDigits = firstTwoDigits - 12;
            return firstTwoDigits + ":" + lastTwoDigits + " p.m.";
        }

        if (firstTwoDigits == 12){
            return firstTwoDigits + ":" + lastTwoDigits + " p.m.";
        }

        if (firstTwoDigits == 00){
            firstTwoDigits = 12;
            return firstTwoDigits + ":" + lastTwoDigits + " a.m.";
        }

        return firstTwoDigits + ":" + lastTwoDigits + " a.m.";

    }


    public static void main(String[] args) {
        String time = "00:00";
        String formattedTime = formatTime(time);
        System.out.println(time + " formatted through formatTime() looks like " + formattedTime);
    }


}


