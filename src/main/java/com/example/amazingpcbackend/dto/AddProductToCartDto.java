package com.example.amazingpcbackend.dto;

import lombok.Data;

@Data
public class AddProductToCartDto {
    private String productId;
    private String userId;
    private int quantity;
}
