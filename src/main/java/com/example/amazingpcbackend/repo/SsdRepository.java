package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Ssd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SsdRepository extends JpaRepository<Ssd, Long> {
    List<Ssd> findByFormFactor(String formFactor);
    List<Ssd> findByCapacity(String capacity);
    List<Ssd> findByWriteVelocity(int writeVelocity);
    List<Ssd> findByReadVelocity(int readVelocity);
    List<Ssd> findByRandomWriteSpeed(int randomWriteSpeed);
}
