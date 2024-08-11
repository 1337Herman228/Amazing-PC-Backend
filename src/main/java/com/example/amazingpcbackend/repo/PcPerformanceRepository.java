package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.PcPerformance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PcPerformanceRepository extends JpaRepository<PcPerformance, Long> {
}
