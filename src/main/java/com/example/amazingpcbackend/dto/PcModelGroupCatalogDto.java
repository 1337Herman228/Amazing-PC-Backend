package com.example.amazingpcbackend.dto;

import com.example.amazingpcbackend.entity.PcModelGroups;
import lombok.Data;

@Data
public class PcModelGroupCatalogDto {
    private PcModelGroups pcModelGroup;
    private float minPrice;
    private String image;
    private int configurationsCount;
}
