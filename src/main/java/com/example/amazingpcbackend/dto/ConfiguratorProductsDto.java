package com.example.amazingpcbackend.dto;

import lombok.Data;

import java.util.List;

@Data
public class ConfiguratorProductsDto {
    private String userId;
    private PcIdWithQuantity pc;
    private List<PartIdWithQuantity> parts;
}
