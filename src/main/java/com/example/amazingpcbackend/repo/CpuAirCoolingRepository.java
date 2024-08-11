package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.CpuAirCooling;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CpuAirCoolingRepository extends JpaRepository<CpuAirCooling, Long> {
    List<CpuAirCooling> findBySockets(String sockets);
    List<CpuAirCooling> findByFansQuantity(int fansQuantity);
    List<CpuAirCooling> findByFanSize(String fanSize);
    List<CpuAirCooling> findByTdp(int tdp);
    List<CpuAirCooling> findByBacklight(String backlight);
    List<CpuAirCooling> findByHeight(int height);
    List<CpuAirCooling> findByFanSpeed(String fanSpeed);
    List<CpuAirCooling> findByAirFlow(float airFlow);
    List<CpuAirCooling> findByMaxNoiseLevel(float maxNoiseLevel);
    List<CpuAirCooling> findByConnector(String connector);
}
