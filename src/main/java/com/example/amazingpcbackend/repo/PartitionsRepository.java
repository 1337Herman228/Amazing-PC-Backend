package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Partitions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PartitionsRepository extends JpaRepository<Partitions, Long> {
    Optional<Partitions> findByPartitionName(String partitionName);
}
