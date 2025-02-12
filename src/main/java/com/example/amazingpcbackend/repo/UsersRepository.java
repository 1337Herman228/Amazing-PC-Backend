package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Person;
import com.example.amazingpcbackend.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {
    Optional<Users> findByLogin(String login);
    Optional<Users> findByPerson(Person person);
}
