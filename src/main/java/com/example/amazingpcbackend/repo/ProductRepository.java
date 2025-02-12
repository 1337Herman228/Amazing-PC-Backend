package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByName(String name);
    List<Product> findByNameContaining(String name);
    List<Product> findByPrice(float price);
}
