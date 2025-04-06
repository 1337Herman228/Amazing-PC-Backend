package com.example.amazingpcbackend.dto;

import lombok.Data;

@Data
public class AddPcModelGroupDto {
    private String id;
    private String pcTypeId;
    private String pcCategoryId;

    private String modelGroupImage;
    private String modelGroupName;
    private String modelGroupDescription;

    private String gpuDescription;
    private String cpuDescription;
    private String motherboardDescription;
    private String ramDescription;
    private String ssdDescription;
    private String psuDescription;

    private String headerDescription;
    private String headerImage;
    private String headerImageMobile;

    private String designTitle;
    private String designDescription;
    private String designImage;

    private String performanceTitle;
    private String performanceDescription;
    private String performanceImage;
}
