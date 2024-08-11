package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Person;
import com.example.amazingpcbackend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByLogin(String login);
    Optional<Users> findByPerson(Person person);
}
