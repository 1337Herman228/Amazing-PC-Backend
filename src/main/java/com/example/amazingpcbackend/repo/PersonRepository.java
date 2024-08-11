package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByNameContaining(String name);
    List<Person> findBySurnameContaining(String surname);
    List<Person> findByPhoneContaining(String phone);
    List<Person> findByEmailContaining(String email);
}
