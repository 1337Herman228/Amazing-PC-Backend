package com.example.amazingpcbackend.dto;

import com.example.amazingpcbackend.entity.CompareItems;
import lombok.Data;

import java.util.List;

@Data
public class CompareItemsDto {
    private List<CompareTypeDto> types;
    private List<CompareItems> items;
}
