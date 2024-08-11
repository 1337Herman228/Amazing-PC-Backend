package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Parts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartsRepository extends JpaRepository<Parts, Long> {
}