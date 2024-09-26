package com.example.amazingpcbackend.controllers;

import com.example.amazingpcbackend.dto.ConfiguratorComponentsListDto;
import com.example.amazingpcbackend.dto.PcCatalogDto;
import com.example.amazingpcbackend.repo.PcCategoriesRepository;
import com.example.amazingpcbackend.services.ConfiguratorService;
import com.example.amazingpcbackend.services.PcService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final ConfiguratorService configuratorService;

    private final PcService pcService;

    @GetMapping("/configurator-parts")
    public ConfiguratorComponentsListDto getConfiguratorParts() {
        return configuratorService.getComponentsList();
    }

    @GetMapping("/pc-categories")
    public PcCatalogDto getGamingPc() {
        return pcService.getGamingPc();
    }

}
