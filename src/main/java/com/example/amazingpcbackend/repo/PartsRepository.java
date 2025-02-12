package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Categories;
import com.example.amazingpcbackend.entity.Partitions;
import com.example.amazingpcbackend.entity.Parts;
import com.example.amazingpcbackend.entity.Types;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PartsRepository extends MongoRepository<Parts, String> {
    List<Parts> findByCategories(Categories category);
    List<Parts> findByPartitions(Partitions partition);
    List<Parts> findByTypes(Types type);
}