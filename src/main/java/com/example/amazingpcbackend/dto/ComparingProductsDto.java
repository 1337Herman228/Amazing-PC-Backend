package com.example.amazingpcbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ComparingProductsDto {
    private String product;
    private int quantity;
}
