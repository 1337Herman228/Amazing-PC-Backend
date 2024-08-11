package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Ram;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RamRepository extends JpaRepository<Ram, Long> {
    List<Ram> findByType(String type);
    List<Ram> findByCapacity(int capacity);
    List<Ram> findByFrequency(int frequency);
}
