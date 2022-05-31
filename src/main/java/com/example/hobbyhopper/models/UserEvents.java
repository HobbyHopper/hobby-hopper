package com.example.hobbyhopper.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_events")
public class UserEvents {

    @Id
    private long userId;

    private long eventId;

    private boolean isOwner;

    private int expertise;

    public UserEvents(long eventId, boolean isOwner, int expertise) {
        this.eventId = eventId;
        this.isOwner = isOwner;
        this.expertise = expertise;
    }

    public UserEvents() {

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

    public int getExpertise() {
        return expertise;
    }

    public void setExpertise(int expertise) {
        this.expertise = expertise;
    }
}
