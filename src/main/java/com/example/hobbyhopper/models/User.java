package com.example.hobbyhopper.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name="users", uniqueConstraints= @UniqueConstraint(columnNames={"username", "email"}))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Min(5)
    private String username;

    @NotBlank
    private String email;

    @NotBlank
    @Min(10)
    private String password;

    private String location;

    private Calendar DOB;

    private String image;

    @Column(columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean isAdmin;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable (name = "user_hobbies",
            joinColumns ={@JoinColumn(name="user_id")},
            inverseJoinColumns = {@JoinColumn(name="hobby_id")}
    )
    private List<Hobby> userHobbies;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserEvent> userEvents;





    public User(User user) {}

    public User(String username, String email, String password, String location, Calendar DOB, String image, Boolean isAdmin, List<Hobby> userHobbies) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.location = location;
        this.DOB = DOB;
        this.image = image;
        this.isAdmin = isAdmin;
        this.userHobbies = userHobbies;
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

    public Calendar getDOB() {
        return DOB;
    }

    public void setDOB(Calendar DOB) {
        this.DOB = DOB;
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

