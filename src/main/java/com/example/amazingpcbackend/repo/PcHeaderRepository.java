package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.PcHeader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PcHeaderRepository extends JpaRepository<PcHeader, Long> {
}
