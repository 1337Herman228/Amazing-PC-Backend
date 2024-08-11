package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Categories;
import com.example.amazingpcbackend.entity.PcCategories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PcCategoriesRepository extends JpaRepository<PcCategories, Long> {
    Optional<PcCategories> findByPcCategoryName(String pcCategoryName);
}
