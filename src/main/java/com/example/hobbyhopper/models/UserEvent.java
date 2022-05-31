package com.example.hobbyhopper.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user_events")
public class UserEvent {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn (name="user_id")
    private User user;
    @ManyToOne
    @JoinColumn (name = "event_id")
    private Event event;

    private boolean isOwner;

    @ManyToOne
    @JoinColumn(name = "expertise_id")
    private Expertise expertise;





    public UserEvent() {}








    public boolean getOwner() {
        return isOwner;
    }

    public void setOwner(boolean owner) {
        isOwner = owner;
    }

    public boolean isOwner() {
        return isOwner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Expertise getExpertise() {
        return expertise;
    }

    public void setExpertise(Expertise expertise) {
        this.expertise = expertise;
    }
}
