package com.example.amazingpcbackend.dto;

import com.example.amazingpcbackend.entity.Parts;
import com.example.amazingpcbackend.entity.PcCategories;
import com.example.amazingpcbackend.entity.PcModelGroups;
import com.example.amazingpcbackend.entity.PcTypes;
import lombok.Data;

import java.util.List;

@Data
public class PcDto {
    private Long pcId;
    private PcModelGroups pcModelGroup;
    private PcTypes pcType;
    private PcCategories pcCategories;
    private String name;
    private String description;
    private String image;
    private float totalPrice;
    private Parts gpu;
    private Parts cpu;
    private Parts motherboard;
    private Parts cpuFan;
    private Parts ram;
    private Parts psu;
    private Parts pcCase;
    private List<SsdDto> ssdList;
    private List<FanDto> fansList;
}
