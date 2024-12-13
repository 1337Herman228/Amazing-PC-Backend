package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Pc;
import com.example.amazingpcbackend.entity.PurchaseItems;
import com.example.amazingpcbackend.entity.PurchaseItemsPc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseItemsPcRepository extends JpaRepository<PurchaseItemsPc, Long> {
    List<PurchaseItems> findByPc(Pc pc);
}
