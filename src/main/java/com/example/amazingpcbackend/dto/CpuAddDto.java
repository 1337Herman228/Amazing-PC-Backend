package com.example.amazingpcbackend.dto;

import lombok.Data;

@Data
public class CpuAddDto {

    private String name;
    private int price;
    private String category;
    private String type;
    private String partition;
    private String description;
    private String image;
    private int remainingQuantity;

    private CpuDto cpu;
}
