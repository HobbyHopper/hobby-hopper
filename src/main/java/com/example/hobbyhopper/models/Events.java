package com.example.hobbyhopper.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Calendar;

@Entity
@Table(name="events")
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime createdEvent;

    private LocalDateTime updatedEvent;

    @NotBlank
    private String eventName;

    @Column(columnDefinition = "TEXT")
    private String eventDescription;

    private String referenceUrl;

    private String address;

    @NotBlank
    private Calendar startDateTime;

    private Calendar endDateTime;

    private boolean isAgeRestricted;

    private boolean isPublic;

    private boolean rsvpAble;

    private String imageUrl;

    @Column(columnDefinition = "BOOLEAN DEFAULT false")
    private boolean isReported;

    private int categoryId;

    public Events(LocalDateTime createdEvent, LocalDateTime updatedEvent, String eventName, String eventDescription, String referenceUrl, String address, Calendar startDateTime, Calendar endDateTime, boolean isAgeRestricted, boolean isPublic, boolean rsvpAble, String imageUrl, boolean isReported, int categoryId) {
        this.createdEvent = createdEvent;
        this.updatedEvent = updatedEvent;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.referenceUrl = referenceUrl;
        this.address = address;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.isAgeRestricted = isAgeRestricted;
        this.isPublic = isPublic;
        this.rsvpAble = rsvpAble;
        this.imageUrl = imageUrl;
        this.isReported = isReported;
        this.categoryId = categoryId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedEvent() {
        return createdEvent;
    }

    public void setCreatedEvent(LocalDateTime createdEvent) {
        this.createdEvent = createdEvent;
    }

    public LocalDateTime getUpdatedEvent() {
        return updatedEvent;
    }

    public void setUpdatedEvent(LocalDateTime updatedEvent) {
        this.updatedEvent = updatedEvent;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getReferenceUrl() {
        return referenceUrl;
    }

    public void setReferenceUrl(String referenceUrl) {
        this.referenceUrl = referenceUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Calendar getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Calendar startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Calendar getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Calendar endDateTime) {
        this.endDateTime = endDateTime;
    }

    public boolean isAgeRestricted() {
        return isAgeRestricted;
    }

    public void setAgeRestricted(boolean ageRestricted) {
        isAgeRestricted = ageRestricted;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public boolean isRsvpAble() {
        return rsvpAble;
    }

    public void setRsvpAble(boolean rsvpAble) {
        this.rsvpAble = rsvpAble;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isReported() {
        return isReported;
    }

    public void setReported(boolean reported) {
        isReported = reported;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
