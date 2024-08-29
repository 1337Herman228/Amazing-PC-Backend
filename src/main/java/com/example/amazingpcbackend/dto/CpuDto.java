package com.example.amazingpcbackend.dto;

import com.example.amazingpcbackend.dao.RamType;
import lombok.Data;

import java.util.List;

@Data
public class CpuDto {
    private int baseFrequency;
    private int boostFrequency;
    private int cpuCores;
    private int cpuThreads;
    private int maxRamCapacity;
    private int tdp;
    private String cachel1;
    private String cachel2;
    private String cachel3;
    private String socket;
    private String techProcess;

//    private RamType ramType;

//  JSON
    private String ramType;

    private int remainingQuantity;
}
