package com.example.amazingpcbackend.dto;

import lombok.Data;

@Data
public class PcToCartDto {
    private String userId;
    private String pcId;
    private int quantity;
}
