package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Parts;
import com.example.amazingpcbackend.entity.Pc;
import com.example.amazingpcbackend.entity.PurchaseItems;
import com.example.amazingpcbackend.entity.Purchases;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseItemsRepository extends JpaRepository<PurchaseItems, Long> {
    List<PurchaseItems> findByPurchase(Purchases purchases);
    List<PurchaseItems> findByPart(Parts part);
    List<PurchaseItems> findByPc(Pc pc);
}
