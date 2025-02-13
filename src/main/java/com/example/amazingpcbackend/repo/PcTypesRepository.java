package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.PcTypes;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PcTypesRepository extends MongoRepository<PcTypes, String> {
    Optional<PcTypes> findByValue(String value);
    Optional<PcTypes> findByLabel(String label);
}
