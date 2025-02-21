package com.example.amazingpcbackend.dto;

import com.example.amazingpcbackend.entity.Categories;
import com.example.amazingpcbackend.entity.Parts;
import com.example.amazingpcbackend.entity.Types;
import lombok.Data;

import java.util.List;

@Data
public class ConfiguratorComponentListItem {
    private Types type;
    private Categories category;
    private List<String> partition;
    private List<Parts> items;
}
