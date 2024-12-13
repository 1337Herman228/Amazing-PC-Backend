package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompareItemsRepository extends JpaRepository<CompareItems, Long> {
}
