package com.example.hobbyhopper.repositories;

import com.example.hobbyhopper.models.Hobby;
import com.example.hobbyhopper.models.User;
import com.example.hobbyhopper.models.UserEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
