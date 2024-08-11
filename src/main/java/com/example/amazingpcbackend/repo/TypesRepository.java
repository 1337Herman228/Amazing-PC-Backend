package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Types;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypesRepository extends JpaRepository<Types, Long> {
    Optional<Types> findByTypeName(String typeName);
    Optional<Types> findByAlternativeName(String alternativeName);
}