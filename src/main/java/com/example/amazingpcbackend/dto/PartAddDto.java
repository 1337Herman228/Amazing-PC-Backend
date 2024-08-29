package com.example.amazingpcbackend.dto;

import com.example.amazingpcbackend.entity.*;
import lombok.Data;

@Data
public class PartAddDto {

    private Long partId;
    private String name;
    private int price;
    private String category; // Комплектующие / Переферия
    private String type; // Процессор / Видеокарта
    private String partition; // intel core 12th / rtx 4060
    private String description;
    private String image;
    private int remainingQuantity;

    private Cpu cpu;
    private Gpu gpu;
    private Motherboard motherboard;
    private Psu psu;
    private CpuAirCooling cpuAirCooling;
    private CpuLiquidCooling cpuLiquidCooling;
    private Ram ram;
    private Ssd ssd;
    private Fans fan;
    private Cases cases;
    private Periphery periphery;
}
