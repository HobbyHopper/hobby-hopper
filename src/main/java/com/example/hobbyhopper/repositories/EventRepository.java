package com.example.hobbyhopper.repositories;

import com.example.hobbyhopper.models.Event;
import com.example.hobbyhopper.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository <Event, Long> {


}
