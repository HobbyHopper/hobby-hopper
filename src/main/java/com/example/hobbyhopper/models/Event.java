package com.example.hobbyhopper.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdEvent;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedEvent;

    @NotBlank
    private String eventName;

    @Column(columnDefinition = "TEXT")
    private String eventDescription;

    private String referenceUrl;

    private String address;

    @NotBlank
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    private String startTime;

    private String endTime;

    private boolean isAgeRestricted;

    private boolean isPublic;

    private boolean rsvpAble;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "event")
    private List<Image> eventImages;

    @Column(columnDefinition = "BOOLEAN DEFAULT false")
    private boolean isReported;

    private int categoryId;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable (name = "event_hobbies",
        joinColumns ={@JoinColumn(name="event_id")},
        inverseJoinColumns = {@JoinColumn(name="hobby_id")}
    )
    private List<Hobby> eventHobbies;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private List<UserEvent> userEvents;



    public Event() {}

    public Event(Date createdEvent, Date updatedEvent, String eventName, String eventDescription, String referenceUrl, String address, Date startDateTime, Date endDateTime, boolean isAgeRestricted, boolean isPublic, boolean rsvpAble, List<Image> eventImages, boolean isReported, int categoryId, List<Hobby> eventHobbies) {
        this.createdEvent = createdEvent;
        this.updatedEvent = updatedEvent;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.referenceUrl = referenceUrl;
        this.address = address;
        this.startDate = startDateTime;
        this.endDate = endDateTime;
        this.isAgeRestricted = isAgeRestricted;
        this.isPublic = isPublic;
        this.rsvpAble = rsvpAble;
        this.eventImages = eventImages;
        this.isReported = isReported;
        this.categoryId = categoryId;
        this.eventHobbies = eventHobbies;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedEvent() {
        return createdEvent;
    }

    public void setCreatedEvent(Date createdEvent) {
        this.createdEvent = createdEvent;
    }

    public Date getUpdatedEvent() {
        return updatedEvent;
    }

    public void setUpdatedEvent(Date updatedEvent) {
        this.updatedEvent = updatedEvent;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public List<Image> getEventImages() {
        return eventImages;
    }

    public void setEventImages(List<Image> eventImages) {
        this.eventImages = eventImages;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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

    public List<Hobby> getEventHobbies() {
        return eventHobbies;
    }

    public void setEventHobbies(List<Hobby> eventHobbies) {
        this.eventHobbies = eventHobbies;
    }

    public List<UserEvent> getUserEvents() {
        return userEvents;
    }

    public void setUserEvents(List<UserEvent> userEvents) {
        this.userEvents = userEvents;
    }
}
