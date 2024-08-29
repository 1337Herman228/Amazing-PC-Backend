package com.example.amazingpcbackend.entity;

import com.example.amazingpcbackend.dao.RamType;
import com.example.amazingpcbackend.dao.converters.RamTypeConverter;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;
import jakarta.persistence.*;

@Entity
@Data
@Table(name = "cpu")
@Accessors(chain = true)
public class Cpu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cpuId;

    @Column(length = 30)
    private String socket; //LGA 1700

    private int maxRamCapacity; //192

//    @Convert(converter = RamTypeConverter.class)
//    @Column(columnDefinition = "json")
//    private RamType ramType;

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
