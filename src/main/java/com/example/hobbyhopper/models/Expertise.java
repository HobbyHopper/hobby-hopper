package com.example.hobbyhopper.models;

import javax.persistence.*;

@Entity
@Table(name="expertise")
public class Expertise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String expertise;

    public Expertise(String expertise) {
        this.expertise = expertise;
    }

    public Expertise() {

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
}
