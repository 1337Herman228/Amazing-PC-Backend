package com.example.amazingpcbackend.controllers;

import com.example.amazingpcbackend.dto.ConfiguratorComponentsListDto;
import com.example.amazingpcbackend.entity.PcCategories;
import com.example.amazingpcbackend.repo.PcCategoriesRepository;
import com.example.amazingpcbackend.services.ConfiguratorService;
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
    private final PcCategoriesRepository pcCategoriesRepository;


    @GetMapping("/configurator-parts")
    public ConfiguratorComponentsListDto getConfiguratorParts() {
        return configuratorService.getComponentsList();
    }

    @GetMapping("/pc-categories")
    public List<PcCategories> getGamingPc() {
        return pcCategoriesRepository.findAll();
    }

}
