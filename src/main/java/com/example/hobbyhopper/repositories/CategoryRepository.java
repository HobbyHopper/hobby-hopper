package com.example.hobbyhopper.repositories;

import com.example.hobbyhopper.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query(" from Category c where c.categoryName like %:term%")
    List<Category> searchByNameLike(@Param("term") String term);


    @Override
    Optional<Category> findById(Long aLong);
}
