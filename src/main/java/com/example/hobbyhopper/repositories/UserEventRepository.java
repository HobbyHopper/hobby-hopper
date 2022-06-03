package com.example.hobbyhopper.repositories;

import com.example.hobbyhopper.models.UserEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEventRepository extends JpaRepository<UserEvent,Long> {
UserEvent getUserEventById(long id);
}
