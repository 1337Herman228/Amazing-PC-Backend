package com.example.amazingpcbackend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AddPcDto extends PcConfigurationDto {
    private String image;
    private String pcTypeId;
    private String pcCategoryId;
    private String pcModelGroupId;
    private String description;
}
