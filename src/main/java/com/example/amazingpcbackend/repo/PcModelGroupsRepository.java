package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.PcCategories;
import com.example.amazingpcbackend.entity.PcModelGroups;
import com.example.amazingpcbackend.entity.PcTypes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PcModelGroupsRepository extends JpaRepository<PcModelGroups, Long> {
    List<PcModelGroups> findByPcTypes(PcTypes pcTypes);
    List<PcModelGroups> findByPcCategories(PcCategories pcCategories);
    Optional<PcModelGroups> findByModelGroupName(String modelGroupName);
}
