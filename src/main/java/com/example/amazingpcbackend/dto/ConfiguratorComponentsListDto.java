package com.example.amazingpcbackend.dto;

import lombok.Data;

import java.util.List;

@Data
public class ConfiguratorComponentsListDto {
    private List<ConfiguratorComponentListItem> components;
}
