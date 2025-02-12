package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Types;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TypesRepository  extends MongoRepository<Types, String> {
    Optional<Types> findByTypeName(String typeName);
    Optional<Types> findByTypeValue(String typeValue);
}
