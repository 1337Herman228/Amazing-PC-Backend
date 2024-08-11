package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.PcTypes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PcTypesRepository extends JpaRepository<PcTypes, Long> {
    Optional<PcTypes> findByType(String type);
}
