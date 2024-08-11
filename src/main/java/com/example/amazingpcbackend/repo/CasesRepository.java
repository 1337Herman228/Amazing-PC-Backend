package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Cases;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CasesRepository extends JpaRepository<Cases, Long> {
    List<Cases> findByMaxCpuCoolerHeight(int maxCpuCoolerHeight);
    List<Cases> findByMaxGpuLength(int maxGpuLength);
    List<Cases> findByMaxLiquidCoolingLength(int maxLiquidCoolingLength);
    List<Cases> findByHddSlotsQuantity(int hddSlotsQuantity);
    List<Cases> findBySsdSlotsQuantity(int ssdSlotsQuantity);
    List<Cases> findByExtensionSlotsQuantity(int extensionSlotsQuantity);
    List<Cases> findByLength(float length);
    List<Cases> findByWidth(float width);
    List<Cases> findByHeight(float height);
    List<Cases> findByWeight(float weight);
    List<Cases> findByPossibleFormFactors(String possibleFormFactors);
}