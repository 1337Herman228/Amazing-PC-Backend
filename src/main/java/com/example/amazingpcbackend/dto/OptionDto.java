package com.example.amazingpcbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
public class OptionDto {
    private String id;
    private String label;
    private String value;
}
