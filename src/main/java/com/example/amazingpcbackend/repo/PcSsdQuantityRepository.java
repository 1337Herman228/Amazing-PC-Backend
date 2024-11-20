package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Pc;
import com.example.amazingpcbackend.entity.PcSsdQuantity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PcSsdQuantityRepository extends JpaRepository<PcSsdQuantity, Long> {
    List<PcSsdQuantity> findByPc(Pc pc);
}
