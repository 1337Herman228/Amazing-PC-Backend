package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PartsRepository extends JpaRepository<Parts, Long> {
    Optional<Parts> findByName(String name);
    List<Parts> findByNameContaining(String name);
    List<Parts> findByPrice(float price);
    List<Parts> findByCategories(Categories category);
    List<Parts> findByPartitions(Partitions partition);
    List<Parts> findByTypes(Types type);
}