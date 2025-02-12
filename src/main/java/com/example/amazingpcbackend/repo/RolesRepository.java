package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Roles;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepository extends MongoRepository<Roles, String> {
    Optional<Roles> findByPosition(String position);
}
