package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Types;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TypesRepository  extends MongoRepository<Types, String> {
    Optional<Types> findByLabel(String label);
    Optional<Types> findByValue(String value);
}
