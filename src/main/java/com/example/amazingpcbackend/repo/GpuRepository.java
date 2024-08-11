package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Gpu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GpuRepository extends JpaRepository<Gpu, Long> {

    List<Gpu> findByTechProcess(int techProcess);
    List<Gpu> findByMaxDisplaysQuantity(int maxDisplaysQuantity);
    List<Gpu> findByMaxResolution(String maxResolution);
    List<Gpu> findByBaseFrequency(String baseFrequency);
    List<Gpu> findByBoostFrequency(String boostFrequency);
    List<Gpu> findByVramCapacity(int vramCapacity);
    List<Gpu> findByVramType(String vramType);
    List<Gpu> findByBusWidth(int busWidth);
    List<Gpu> findByHdmi(int hdmi);
    List<Gpu> findByDisplayPort(int displayPort);
    List<Gpu> findByCuda(int cuda);
    List<Gpu> findByPowerConnector(String powerConnector);
    List<Gpu> findByMinPowerUnit(int minPowerUnit);
    List<Gpu> findByFans(int fans);
    List<Gpu> findByExtensionSlots(String extensionSlots);
    List<Gpu> findByLength(int length);
    List<Gpu> findByWidth(int width);
    List<Gpu> findByHeight(int height);
}

