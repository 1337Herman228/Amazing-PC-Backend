package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Product;
import com.example.amazingpcbackend.entity.PurchaseItem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PurchaseItemRepository extends MongoRepository<PurchaseItem, String> {
    Optional<PurchaseItem> findByProduct(Product product);
}
