package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.PcCategories;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PcCategoriesRepository extends MongoRepository<PcCategories, String> {
    Optional<PcCategories> findByPcCategoryName(String name);
    Optional<PcCategories> findByPcCategoryValue(String value);
}
