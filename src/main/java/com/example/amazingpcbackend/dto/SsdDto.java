package com.example.amazingpcbackend.dto;

import com.example.amazingpcbackend.entity.Parts;
import lombok.Data;

@Data
public class SsdDto {
    private Parts ssd;
    private int quantity;
}
