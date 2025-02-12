package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.CompareItems;
import com.example.amazingpcbackend.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CompareItemsRepository extends MongoRepository<CompareItems, String> {
    List<CompareItems> findByUser(Users user);
}
