package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.PcCategories;
import com.example.amazingpcbackend.entity.PcModelGroups;
import com.example.amazingpcbackend.entity.PcTypes;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PcModelGroupsRepository extends MongoRepository<PcModelGroups, String> {
    List<PcModelGroups> findByPcTypes(PcTypes pcTypes);
    List<PcModelGroups> findByPcCategories(PcCategories pcCategories);
    Optional<PcModelGroups> findByModelGroupName(String modelGroupName);
}
