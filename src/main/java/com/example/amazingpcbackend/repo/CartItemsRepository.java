package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.CartItems;
import com.example.amazingpcbackend.entity.PurchaseItem;
import com.example.amazingpcbackend.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemsRepository extends MongoRepository<CartItems, String> {
    List<CartItems> findByUser(Users user);

    Optional<CartItems> findByItem(PurchaseItem item);
}
