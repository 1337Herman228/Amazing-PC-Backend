package com.example.amazingpcbackend.dto;

import com.example.amazingpcbackend.entity.PcModelGroups;
import lombok.Data;

@Data
public class PcModelGroupCatalogDto {
    PcModelGroups pcModelGroup;
    float minPrice;
    String image;
    int configurationsCount;
}
