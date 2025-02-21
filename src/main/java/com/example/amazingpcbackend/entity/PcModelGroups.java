package com.example.amazingpcbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "pc_model_groups")
public class PcModelGroups {

    @Id
    private String id;

    @DBRef
    private PcTypes pcTypes;

    @DBRef
    private PcCategories pcCategories;

    private String modelGroupImage;
    private String modelGroupName; //One
    private String modelGroupDescription; //Начальный игровой компьютер

    private String gpuDescription; //...
    private String cpuDescription; //...
    private String motherboardDescription; //...
    private String ramDescription; //...
    private String ssdDescription; //...
    private String psuDescription; //...

    private String headerDescription;
    private String headerImage;
    private String headerImageMobile;

    private String designTitle;
    private String designDescription;
    private String designImage;

    private String performanceTitle;
    private String performanceDescription;
    private String performanceImage;
    private String performanceImage2;
}
