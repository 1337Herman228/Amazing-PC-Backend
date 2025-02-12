package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PcRepository  extends MongoRepository<Pc, String> {
    List<Pc> findByPcModelGroup(PcModelGroups pcModelGroup);
    List<Pc> findByPcType(PcTypes pcType);
    List<Pc> findByPcCategories(PcCategories pcCategory);
    List<Pc> findByGpu(Parts gpu);
    List<Pc> findByMotherboard(Parts motherboard);
    List<Pc> findByCpuFan(Parts cpuFan);
    List<Pc> findByRam(Parts ram);
    List<Pc> findByPsu(Parts psu);
    List<Pc> findByPcCase(Parts pcCase);
}