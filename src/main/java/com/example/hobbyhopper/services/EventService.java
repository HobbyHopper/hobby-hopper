package com.example.hobbyhopper.services;

import org.springframework.stereotype.Service;

@Service
public class EventService {

    public String formatTime(String time){

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

    public String getMonthString(int month){
        return switch (month) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> null;
        };
    }

}


