package com.example.amazingpcbackend.dto;

import lombok.Data;

@Data
public class EditPurchaseDto {
    private String id;
    private String userId;
    private String status;
    private String destination;
}
