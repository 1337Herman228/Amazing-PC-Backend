package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Fans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FansRepository extends JpaRepository<Fans, Long> {
}
