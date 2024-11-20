package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Pc;
import com.example.amazingpcbackend.entity.PcFansQuantity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PcFansQuantityRepository extends JpaRepository<PcFansQuantity, Long> {
    List<PcFansQuantity> findByPc(Pc pc);
}
