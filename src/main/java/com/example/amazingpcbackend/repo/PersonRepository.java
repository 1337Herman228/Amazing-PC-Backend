package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Person;
import com.example.amazingpcbackend.entity.Roles;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
    Optional<Person> findByEmail(String email);
}
