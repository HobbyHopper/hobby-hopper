package com.example.hobbyhopper.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="expertise")
public class Expertise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String expertise;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "expertise")
    private List<UserEvents> userEvents;




    public Expertise() {}

    public Expertise(String expertise, List<UserEvents> userEvents) {
        this.expertise = expertise;
        this.userEvents = userEvents;
    }





    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public List<UserEvents> getUserEvents() {
        return userEvents;
    }

    public void setUserEvents(List<UserEvents> userEvents) {
        this.userEvents = userEvents;
    }
}
