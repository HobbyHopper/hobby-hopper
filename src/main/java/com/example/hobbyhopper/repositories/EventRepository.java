package com.example.hobbyhopper.repositories;

import com.example.hobbyhopper.models.Event;
import com.example.hobbyhopper.models.Image;
import com.example.hobbyhopper.models.UserEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository <Event, Long> {


}
