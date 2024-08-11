package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Periphery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeripheryRepository extends JpaRepository<Periphery, Long> {
    List<Periphery> findByCharacteristics(String characteristics);
}
