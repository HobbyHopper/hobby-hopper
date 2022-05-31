package com.example.hobbyhopper.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user_events")
public class UserEvents {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long userId;

    private long eventId;

    private boolean isOwner;

    @ManyToOne
    @JoinColumn(name = "expertise_id")
    private Expertise expertise;





    public UserEvents() {}

    public UserEvents(long userId, long eventId, boolean isOwner, Expertise expertise) {
        this.userId = userId;
        this.eventId = eventId;
        this.isOwner = isOwner;
        this.expertise = expertise;
    }





    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

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
