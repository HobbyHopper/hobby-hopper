package com.example.hobbyhopper.repositories;

import com.example.hobbyhopper.models.Event;
import com.example.hobbyhopper.models.Hobby;
import com.example.hobbyhopper.models.Image;
import com.example.hobbyhopper.models.UserEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends JpaRepository <Event, Long> {

    List<Event> findAllByIsPublic(boolean isPublic);

    @Query(" from Event e where e.eventName like %:term%")
    List<Event> searchByTitleLike(@Param("term") String term);

    List<Event> findByCategoryId(int categoryId);









}
