package com.example.amazingpcbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@AllArgsConstructor
@Data
public class SellingTypesDto {
    private String type;
    private float percentage;
}
