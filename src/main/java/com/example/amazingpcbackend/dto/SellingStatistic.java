package com.example.amazingpcbackend.dto;

import lombok.Data;

import java.util.List;

@Data
public class SellingStatistic {

    private float totalSell;
    List<SellingTypesDto> data;
}
