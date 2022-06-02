package com.example.hobbyhopper.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="users", uniqueConstraints= @UniqueConstraint(columnNames={"username", "email"}))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Min(5)
    private String username;

    @NotNull
    private String email;

    @NotNull
    @Min(10)
    private String password;

    private String location;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    private String image;

    @Column(columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean isAdmin = false;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable (name = "user_hobbies",
            joinColumns ={@JoinColumn(name="user_id")},
            inverseJoinColumns = {@JoinColumn(name="hobby_id")}
    )
    private List<Hobby> userHobbies;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserEvent> userEvents;


    public User() {}

    public User(String username, String email, String password, String location, Date dob, String image, Boolean isAdmin, List<Hobby> userHobbies) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.location = location;
        this.dob = dob;
        this.image = image;
        this.isAdmin = isAdmin;
        this.userHobbies = userHobbies;
    }

    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
        location = copy.location;
        dob = copy.dob;
        image = copy.image;
        isAdmin = copy.isAdmin;
        userHobbies = copy.userHobbies;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public List<UserEvent> getUserEvents() {
        return userEvents;
    }

    public void setUserEvents(List<UserEvent> userEvents) {
        this.userEvents = userEvents;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public List<Hobby> getUserHobbies() {
        return userHobbies;
    }

    public void setUserHobbies(List<Hobby> userHobbies) {
        this.userHobbies = userHobbies;
    }
}

