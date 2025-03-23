package com.example.amazingpcbackend.dto;

import com.example.amazingpcbackend.entity.Pc;
import com.example.amazingpcbackend.entity.PcModelGroups;
import lombok.Data;

@Data
public class CatalogDto {
    private int configurationsCount;
    private float minPrice;
    private Pc pc;
    private PcModelGroups pcModelGroup;
}
