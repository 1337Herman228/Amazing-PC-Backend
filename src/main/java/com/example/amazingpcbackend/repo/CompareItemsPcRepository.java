package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.CompareItemsPc;
import com.example.amazingpcbackend.entity.Pc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompareItemsPcRepository extends JpaRepository<CompareItemsPc, Long> {
    List<CompareItemsPc> findByPc(Pc pc);
}
