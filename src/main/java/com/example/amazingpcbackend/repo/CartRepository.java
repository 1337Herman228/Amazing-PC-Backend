package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Cart.Cart;
import com.example.amazingpcbackend.entity.PurchaseItems;
import com.example.amazingpcbackend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByUser(Users user);
    Optional<Cart> findByPurchaseItem(PurchaseItems purchaseItem);
}
