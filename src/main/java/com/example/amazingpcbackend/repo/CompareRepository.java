package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Cart.Cart;
import com.example.amazingpcbackend.entity.Compare.Compare;
import com.example.amazingpcbackend.entity.CompareItems;
import com.example.amazingpcbackend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompareRepository extends JpaRepository<Compare, Long> {
    List<Compare> findByUser(Users user);
    Optional<Compare> findByCompareItem(CompareItems compareItem);
}
