package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Purchases;
import com.example.amazingpcbackend.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.sql.Timestamp;
import java.util.List;

public interface PurchasesRepository extends MongoRepository<Purchases, String> {
    List<Purchases> findByUser(Users users);
    List<Purchases> findByDestinationContaining(String destination);
    List<Purchases> findByDate(Timestamp date);
}
