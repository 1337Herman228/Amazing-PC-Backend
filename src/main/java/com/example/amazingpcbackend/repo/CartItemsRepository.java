package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.CartItems;
import com.example.amazingpcbackend.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CartItemsRepository extends MongoRepository<CartItems, String> {
    List<CartItems> findByUser(Users user);
}
