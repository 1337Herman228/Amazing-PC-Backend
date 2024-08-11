package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<Roles, Long> {
    Optional<Roles> findByPosition(String position);
}
