package com.example.amazingpcbackend.controllers;

import com.example.amazingpcbackend.dto.ConfiguratorComponentsListDto;
import com.example.amazingpcbackend.entity.*;
import com.example.amazingpcbackend.repo.*;
import com.example.amazingpcbackend.services.ConfiguratorService;
import com.example.amazingpcbackend.services.PcService;
import com.example.amazingpcbackend.services.PurchasesService;
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
    private final PurchasesService purchasesService;
    private final PcCategoriesRepository pcCategoriesRepository;
    private final PcTypesRepository pcTypesRepository;
    private final PcModelGroupsRepository pcModelGroupsRepository;
    private final PcService pcService;
    private final ConfiguratorService configuratorService;

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

    @GetMapping("/user-cart/{id}")
    public List<PurchaseItem> getUserCartItems(@PathVariable String id) {
        return purchasesService.getUserCartItems(id);
    }

    @GetMapping("/pc-categories")
    public List<PcCategories> getPcCategories() {
        return pcCategoriesRepository.findAll();
    }

    @GetMapping("/not-empty-pc-categories")
    public List<PcCategories> getNotEmptyPcCategories() {
        return pcService.getNonEmptyPcCategories();
    }

    @GetMapping("/pc-types")
    public List<PcTypes> getPcTypes() {
        return pcTypesRepository.findAll();
    }

    @GetMapping("/gaming-pc-catalog")
    public List<PcModelGroups> getGamingPcCatalog() {
        return pcModelGroupsRepository.findByPcTypes(pcTypesRepository.findByValue("gaming-pc").get());
    }

    @GetMapping("/notebooks-catalog")
    public List<PcModelGroups> getNotebooksCatalog() {
        return pcModelGroupsRepository.findByPcTypes(pcTypesRepository.findByValue("notebook").get());
    }

    @GetMapping("/workstations-catalog")
    public List<PcModelGroups> getWorkstationsCatalog() {
        return pcModelGroupsRepository.findByPcTypes(pcTypesRepository.findByValue("workstation").get());
    }

    @GetMapping("/get-pc-by-model-group-name/{modelGroupName}")
    public List<Pc> getPcsByModelGroupName(@PathVariable String modelGroupName) {
        return pcService.getPcsByModelGroupName(modelGroupName);
    }

    @GetMapping("/configurator-parts")
    public ConfiguratorComponentsListDto getConfiguratorParts() {
        return configuratorService.getComponentsList();
    }



//    @GetMapping("/pc-model-groups")
//    public List<Pc> getPcCatalog() {
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

//


}
