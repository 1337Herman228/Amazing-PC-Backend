package com.example.amazingpcbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Table(name = "cpu_air_cooling")
@Accessors(chain = true)
public class CpuAirCooling {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cpuAirCoolingId;

    //JSON
    private String sockets; // Am4, Am5 , Lga1700

    private int fansQuantity; //2

    @Column(length = 30)
    private String fanSize; //120 мм

    private int tdp; //65 W

    @Column(length = 30)
    private String backlight; //RGB

    private int height; //140

    @Column(length = 45)
    private String fanSpeed; //500-2000 об/мин

    private float airFlow; //75.7 CFM
    private float maxNoiseLevel; //30 дб

    @Column(length = 30)
    private String connector; //4 pin PWM

}
