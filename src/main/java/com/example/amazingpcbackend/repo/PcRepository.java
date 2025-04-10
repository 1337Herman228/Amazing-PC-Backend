package com.example.amazingpcbackend.repo;

import com.example.amazingpcbackend.entity.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface PcRepository  extends MongoRepository<Pc, String> {
    List<Pc> findByPcModelGroup(PcModelGroups pcModelGroup);
    List<Pc> findByUserCreated(Users user);
    Optional<Pc> findByName(String name);
}