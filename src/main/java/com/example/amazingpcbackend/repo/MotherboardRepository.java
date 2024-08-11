package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Motherboard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MotherboardRepository extends JpaRepository<Motherboard, Long> {
    List<Motherboard> findBySocket(String socket);
    List<Motherboard> findByFormFactor(String formFactor);
    List<Motherboard> findByChipset(String chipset);
    List<Motherboard> findByRamType(String ramType);
    List<Motherboard> findByRamSlots(int ramSlots);
    List<Motherboard> findByMaxRamCapacity(int maxRamCapacity);
    List<Motherboard> findBySataQuantity(int sataQuantity);
    List<Motherboard> findByM2Quantity(int m2Quantity);
    List<Motherboard> findByPcie16Quantity(int pcie16Quantity);
}
