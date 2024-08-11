package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Purchases;
import com.example.amazingpcbackend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PurchasesRepository extends JpaRepository<Purchases, Long> {
    List<Purchases> findByUsers(Users users);
    List<Purchases> findByDestinationContaining(String destination);
    List<Purchases> findByDate(Date date);
}
