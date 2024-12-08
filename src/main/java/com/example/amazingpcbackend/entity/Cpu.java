package com.example.amazingpcbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import jakarta.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "cpu")
@Accessors(chain = true)
public class Cpu extends Parts {

    @Column(length = 30)
    private String socket; //LGA 1700

    private int maxRamCapacity; //192

    //JSON
    @Column(length = 300)
    private String ramType;

    private int cpuCores; //6
    private int cpuThreads; //12
    private int baseFrequency; //2600
    private int boostFrequency; //5200

    @Column(length = 30)
    private String techProcess; //intel 7

    @Column(length = 30)
    private String cacheL1; //80 КБ

    @Column(length = 30)
    private String cacheL2; //11.5 MБ

    @Column(length = 30)
    private String cacheL3; //24 MБ

    private int tdp; //65
}
