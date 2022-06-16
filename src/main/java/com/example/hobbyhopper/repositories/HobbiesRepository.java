package com.example.hobbyhopper.repositories;

import com.example.hobbyhopper.models.Event;
import com.example.hobbyhopper.models.Hobby;
import com.example.hobbyhopper.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HobbiesRepository extends JpaRepository <Hobby,Long> {
    Hobby findByHobbyName(String hobbyName);

    @Query(" from Hobby h where h.hobbyName like %:term%")
    List<Hobby> searchByNameLike(@Param("term") String term);

    boolean existsByHobbyNameIgnoreCase(String hobbyName);

    boolean existsByUsersAndHobbyNameIgnoreCase(User users, String hobbyName);








}
