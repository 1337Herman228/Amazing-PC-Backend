package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Cases;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CasesRepository extends JpaRepository<Cases, Long> {
}