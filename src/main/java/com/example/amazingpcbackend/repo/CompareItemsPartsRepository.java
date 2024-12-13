package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.CompareItemsParts;
import com.example.amazingpcbackend.entity.Parts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompareItemsPartsRepository extends JpaRepository<CompareItemsParts, Long> {
    List<CompareItemsParts> findByPart(Parts parts);
}
