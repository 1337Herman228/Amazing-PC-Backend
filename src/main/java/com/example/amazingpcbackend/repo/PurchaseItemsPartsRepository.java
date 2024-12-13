package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Parts;
import com.example.amazingpcbackend.entity.PurchaseItems;
import com.example.amazingpcbackend.entity.PurchaseItemsParts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseItemsPartsRepository  extends JpaRepository<PurchaseItemsParts, Long> {
    List<PurchaseItems> findByPart(Parts part);
}
