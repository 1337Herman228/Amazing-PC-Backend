package com.example.amazingpcbackend.controllers;

import com.example.amazingpcbackend.dto.ConfiguratorComponentsListDto;
import com.example.amazingpcbackend.dto.PcCatalogDto;
import com.example.amazingpcbackend.dto.PcDto;
import com.example.amazingpcbackend.entity.PurchaseItems;
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

    private final ConfiguratorService configuratorService;
    private final PurchasesService purchasesService;

    private final PcService pcService;

    @GetMapping("/configurator-parts")
    public ConfiguratorComponentsListDto getConfiguratorParts() {
        return configuratorService.getComponentsList();
    }

    @GetMapping("/gaming-pc-catalog")
    public PcCatalogDto getGamingPc() {
        return pcService.getPcCatalog("gaming-pc");
    }

    @GetMapping("/notebooks-catalog")
    public PcCatalogDto getNotebooks() {
        return pcService.getPcCatalog("notebook");
    }

    @GetMapping("/workstations-catalog")
    public PcCatalogDto getWorkStations() {
        return pcService.getPcCatalog("workstation");
    }

    @GetMapping("/get-pc-by-model-group-name/{modelGroupName}")
    public List<PcDto> getPcsByModelGroupName(@PathVariable String modelGroupName) {
        return pcService.getPcsByModelGroupName(modelGroupName);
    }

    @GetMapping("/get-user-cart-items/{userId}")
    public List<PurchaseItems> getUserCartItems(@PathVariable Long userId) {
        return purchasesService.getUserCartItems(userId);
    }

}
