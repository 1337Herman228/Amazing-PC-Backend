package com.example.amazingpcbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class PcIdWithQuantity {
    private String pcId;
    private int quantity;
}
