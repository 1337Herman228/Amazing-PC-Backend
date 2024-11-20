package com.example.amazingpcbackend.dto;

import com.example.amazingpcbackend.entity.Fans;
import com.example.amazingpcbackend.entity.Parts;
import lombok.Data;

@Data
public class FanDto {
    private Parts fan;
    private int quantity;
}
