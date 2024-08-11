package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Fans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FansRepository extends JpaRepository<Fans, Long> {

    List<Fans> findByFanSize(String fanSize);
    List<Fans> findByFanSpeed(String fanSpeed);
    List<Fans> findByAirFlow(String airFlow);
    List<Fans> findByMaxNoiseLevel(float maxNoiseLevel);
    List<Fans> findByBacklight(String backlight);
}
