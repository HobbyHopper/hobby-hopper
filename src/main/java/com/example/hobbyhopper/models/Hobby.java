package com.example.hobbyhopper.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name="hobbies")
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Min(3)
    private String hobbyName;

    @ManyToMany(mappedBy = "userHobbies")
    private List<User> users;

    @ManyToMany(mappedBy = "eventHobbies")
    private List<Event> events;


    public Hobby(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public Hobby() {}

    public Hobby(String hobbyName, List<User> users, List<Event> events) {
        this.hobbyName = hobbyName;
        this.users = users;
        this.events = events;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
