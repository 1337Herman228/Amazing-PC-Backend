package com.example.amazingpcbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SalesIncomePerPeriodDto {
    private String date;
    private float income;
}
