package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {
    Optional<Categories> findByCategoryName(String categoryName);
}