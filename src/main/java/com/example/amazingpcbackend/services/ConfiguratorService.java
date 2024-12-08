package com.example.amazingpcbackend.services;

import com.example.amazingpcbackend.dto.ConfiguratorComponentListItem;
import com.example.amazingpcbackend.dto.ConfiguratorComponentsListDto;
import com.example.amazingpcbackend.entity.Partitions;
import com.example.amazingpcbackend.entity.Parts;
import com.example.amazingpcbackend.entity.Types;
import com.example.amazingpcbackend.repo.PartsRepository;
import com.example.amazingpcbackend.repo.TypesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ConfiguratorService {

    private final PartsRepository partsRepository;
    private final TypesRepository typesRepository;

//    public ConfiguratorComponentsListDto getComponentsList() {
//        ConfiguratorComponentsListDto configuratorComponentsListDto = new ConfiguratorComponentsListDto();
//        List<ConfiguratorComponentListItem> components = new ArrayList<>();
//
//        List<Types> allTypes = typesRepository.findAll();
//
//        for (Types type : allTypes) {
//            ConfiguratorComponentListItem component = new ConfiguratorComponentListItem();
//            component.setType(type);
//
//            List<Parts> parts = partsRepository.findByTypes(type);
//            component.setCategory(parts.get(0).getCategories());
//            component.setItems(parts);
//
//            List<Partitions> partitions = new ArrayList<>();
//            List<String> listOfPartitions = new ArrayList<>();
//            for (Parts part : parts) {
//                if (part.getPartitions() != null) {
//                    partitions.add(part.getPartitions());
//                }
//            }
//            for(Partitions partition : partitions) {
//                listOfPartitions.add(partition.getPartitionName());
//            }
//            Set<String> set = new HashSet<>(listOfPartitions);
//            listOfPartitions.clear();
//            listOfPartitions.addAll(set);
//
//            component.setPartition(listOfPartitions);
//            components.add(component);
//        }
//
//        configuratorComponentsListDto.setComponents(components);
//        return configuratorComponentsListDto;
//    }

    public ConfiguratorComponentsListDto getComponentsList() {
        ConfiguratorComponentsListDto configuratorComponentsListDto = new ConfiguratorComponentsListDto();
        List<ConfiguratorComponentListItem> components = new ArrayList<>();

        List<Types> allTypes = typesRepository.findAll();

        for (Types type : allTypes) {
            ConfiguratorComponentListItem component = new ConfiguratorComponentListItem();
            component.setType(type);

            List<Parts> parts = partsRepository.findByTypes(type);
            component.setCategory(parts.get(0).getCategories());
            component.setItems(parts);

            List<Partitions> partitions = new ArrayList<>();
            List<String> listOfPartitions = new ArrayList<>();
            for (Parts part : parts) {
                if (part.getPartitions() != null) {
                    partitions.add(part.getPartitions());
                }
            }
            for(Partitions partition : partitions) {
                listOfPartitions.add(partition.getPartitionName());
            }
            Set<String> set = new HashSet<>(listOfPartitions);
            listOfPartitions.clear();
            listOfPartitions.addAll(set);

            component.setPartition(listOfPartitions);
            components.add(component);
        }

        configuratorComponentsListDto.setComponents(components);
        return configuratorComponentsListDto;
    }

}
