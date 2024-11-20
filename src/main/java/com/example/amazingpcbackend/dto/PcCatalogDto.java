package com.example.amazingpcbackend.dto;

import com.example.amazingpcbackend.entity.PcCategories;
import lombok.Data;

import java.util.List;

@Data
public class PcCatalogDto {
    private List<PcCategories> pcCategories;
    private List<PcModelGroupCatalogDto> pcModelGroupList;
}
