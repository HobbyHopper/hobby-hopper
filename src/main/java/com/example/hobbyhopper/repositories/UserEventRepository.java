package com.example.hobbyhopper.repositories;

import com.example.hobbyhopper.models.Event;
import com.example.hobbyhopper.models.User;
import com.example.hobbyhopper.models.UserEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserEventRepository extends JpaRepository<UserEvent,Long> {
    UserEvent getUserEventById(long id);

    UserEvent findByEventAndUserAndIsOwner(Event event, User user, boolean isOwner);

    UserEvent findByEventAndUserAndIsOwnerFalse(Event event, User user);

    List<UserEvent> findAllByUserAndIsOwner(User user,Boolean isOwner);

    UserEvent findByUser(User user);






}
