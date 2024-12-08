package com.example.amazingpcbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "cases")
@Accessors(chain = true)
public class Cases extends Parts{

    private int maxCpuCoolerHeight; //168 мм
    private int maxGpuLength; //330 мм
    private int maxLiquidCoolingLength; //250 мм
    private int hddSlotsQuantity; //1
    private int ssdSlotsQuantity; //3
    private int extensionSlotsQuantity; //7
    private float length; //386 мм
    private float width; //204 мм
    private float height; //401 мм
    private float weight; //5.68 кг

    // JSON
    private String possibleFormFactors;
}
