package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Psu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PsuRepository extends JpaRepository<Psu, Long> {
    List<Psu> findByPower(int power);
    List<Psu> findByFormFactor(String formFactor);
    List<Psu> findByPfc(String pfc);
    List<Psu> findByCoolingSystem(String coolingSystem);
    List<Psu> findByMbConnector(String mbConnector);
    List<Psu> findByCertificate(String certificate);
    List<Psu> findByModular(String modular);
}

