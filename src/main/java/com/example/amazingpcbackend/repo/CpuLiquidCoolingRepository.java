package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.CpuLiquidCooling;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CpuLiquidCoolingRepository extends JpaRepository<CpuLiquidCooling, Long> {
    List<CpuLiquidCooling> findBySockets(String sockets);
    List<CpuLiquidCooling> findByFansQuantity(int fansQuantity);
    List<CpuLiquidCooling> findByFanSize(String fanSize);
    List<CpuLiquidCooling> findByTdp(int tdp);
    List<CpuLiquidCooling> findByBacklight(String backlight);
    List<CpuLiquidCooling> findByLength(float length);
    List<CpuLiquidCooling> findByWidth(float width);
    List<CpuLiquidCooling> findByHeight(float height);
    List<CpuLiquidCooling> findByFanSpeed(String fanSpeed);
    List<CpuLiquidCooling> findByAirFlow(float airFlow);
    List<CpuLiquidCooling> findByMaxNoiseLevel(float maxNoiseLevel);
    List<CpuLiquidCooling> findByConnector(String connector);
}
