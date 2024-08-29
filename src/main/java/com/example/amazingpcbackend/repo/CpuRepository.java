package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.Cpu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CpuRepository extends JpaRepository<Cpu, Long> {

    List<Cpu> findBySocket(String socket);
    List<Cpu> findByMaxRamCapacity(int maxRamCapacity);
    List<Cpu> findByRamType(String ramType);
    List<Cpu> findByCpuCores(int cpuCores);
    List<Cpu> findByCpuThreads(int cpuThreads);
    List<Cpu> findByBaseFrequency(int baseFrequency);
    List<Cpu> findByBoostFrequency(int boostFrequency);
    List<Cpu> findByTechProcess(String techProcess);
    List<Cpu> findByCacheL1(String cashL1);
    List<Cpu> findByCacheL2(String cashL2);
    List<Cpu> findByCacheL3(String cashL3);
    List<Cpu> findByTdp(int tdp);

}
