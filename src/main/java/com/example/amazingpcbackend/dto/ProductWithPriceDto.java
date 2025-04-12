package com.example.amazingpcbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductWithPriceDto {
    private String product;
    private float price;
}
