package com.example.amazingpcbackend.dto;

import com.example.amazingpcbackend.entity.Categories;
import lombok.Data;

@Data
public class PartDro {
    private Long partId;
    private String name;
    private String image;
    private String description;
    private float price;
    private int remainingQuantity;
    private Categories categories;
}
