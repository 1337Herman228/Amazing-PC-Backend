package com.example.amazingpcbackend.controllers;

import com.example.amazingpcbackend.entity.Categories;
import com.example.amazingpcbackend.entity.Partitions;
import com.example.amazingpcbackend.entity.Parts;
import com.example.amazingpcbackend.entity.Types;
import com.example.amazingpcbackend.repo.CategoriesRepository;
import com.example.amazingpcbackend.repo.PartitionsRepository;
import com.example.amazingpcbackend.repo.PartsRepository;
import com.example.amazingpcbackend.repo.TypesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final TypesRepository typesRepository;
    private final CategoriesRepository categoriesRepository;
    private final PartitionsRepository partitionsRepository;
    private final PartsRepository partsRepository;

    @GetMapping("/types")
    public List<Types> getTypes() {
        return typesRepository.findAll();
    }

    @GetMapping("/categories")
    public List<Categories> getCategories() {
        return categoriesRepository.findAll();
    }

    @GetMapping("/partitions")
    public List<Partitions> getPartitions() {
        return partitionsRepository.findAll();
    }

    @GetMapping("/parts")
    public List<Parts> getParts() {
        return partsRepository.findAll();
    }

    @GetMapping("/parts/{id}")
    public Parts getPartById(@PathVariable String id) {
        return partsRepository.findById(id).orElse(null);
    }

    @GetMapping("/types/{id}")
    public Types getTypeByID(@PathVariable String id) {
        return typesRepository.findById(id).orElse(null);
    }

    @GetMapping("/partitions/{id}")
    public Partitions getPartitionByID(@PathVariable String id) {
        return partitionsRepository.findById(id).orElse(null);
    }


//    @GetMapping("/configurator-parts")
//    public ConfiguratorComponentsListDto getConfiguratorParts() {
//        return configuratorService.getComponentsList();
//    }
//
//    @GetMapping("/gaming-pc-catalog")
//    public PcCatalogDto getGamingPc() {
//        return pcService.getPcCatalog("gaming-pc");
//    }
//
//    @GetMapping("/notebooks-catalog")
//    public PcCatalogDto getNotebooks() {
//        return pcService.getPcCatalog("notebook");
//    }
//
//    @GetMapping("/workstations-catalog")
//    public PcCatalogDto getWorkStations() {
//        return pcService.getPcCatalog("workstation");
//    }
//
//    @GetMapping("/get-pc-by-model-group-name/{modelGroupName}")
//    public List<PcDto> getPcsByModelGroupName(@PathVariable String modelGroupName) {
//        return pcService.getPcsByModelGroupName(modelGroupName);
//    }
//
//    @GetMapping("/get-user-cart-items/{userId}")
//    public List<PurchaseItems> getUserCartItems(@PathVariable Long userId) {
//        return purchasesService.getUserCartItems(userId);
//    }

}
