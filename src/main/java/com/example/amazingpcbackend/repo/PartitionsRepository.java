package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Partitions;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PartitionsRepository extends MongoRepository<Partitions, String> {
    Optional<Partitions> findByPartitionName(String partitionName);
    Optional<Partitions> findByPartitionValue(String partitionValue);
}

