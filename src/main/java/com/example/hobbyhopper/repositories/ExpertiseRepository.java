package com.example.hobbyhopper.repositories;

import com.example.hobbyhopper.models.Expertise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpertiseRepository extends JpaRepository<Expertise,Long> {
    Expertise findById(long id);
}
