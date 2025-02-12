package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Categories;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CategoriesRepository extends MongoRepository<Categories, String> {
    Optional<Categories> findByCategoryName(String categoryName);
    Optional<Categories> findByCategoryValue(String categoryValue);
}
