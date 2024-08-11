package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PartsRepository extends JpaRepository<Parts, Long> {
    List<Parts> findByNameContaining(String name);
    List<Parts> findByPrice(float price);
    Optional<Parts> findByCategories(Categories category);
    Optional<Parts> findByPartitions(Partitions partition);
    Optional<Parts> findByTypes(Types type);
    Optional<Parts> findByCpu(Cpu cpu);
    Optional<Parts> findByGpu(Gpu gpu);
    Optional<Parts> findByMotherboard(Motherboard motherboard);
    Optional<Parts> findByPsu(Psu psu);
    Optional<Parts> findByFan(Fans fan);
    Optional<Parts> findByCases(Cases cases);
    Optional<Parts> findByPeriphery(Periphery periphery);
}