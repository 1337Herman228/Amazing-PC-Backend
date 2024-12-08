package com.example.amazingpcbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Table(name = "parts")
@Accessors(chain = true)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Parts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long partId;

    @Column(unique = true, nullable = false, length = 130)
    private String name;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(nullable = false)
    private float price;

    private int remainingQuantity;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private Categories categories;

    @ManyToOne
    @JoinColumn(name = "partitionId", nullable = false)
    private Partitions partitions;

    @ManyToOne
    @JoinColumn(name = "typeId", nullable = false)
    private Types types;

    //////

//    @OneToOne
//    @JoinColumn(name = "cpuId", referencedColumnName = "cpuId")
//    private Cpu cpu;
//
//    @OneToOne
//    @JoinColumn(name = "gpuId", referencedColumnName = "gpuId")
//    private Gpu gpu;
//
//    @OneToOne
//    @JoinColumn(name = "motherboardId", referencedColumnName = "motherboardId")
//    private Motherboard motherboard;
//
//    @OneToOne
//    @JoinColumn(name = "psuId", referencedColumnName = "psuId")
//    private Psu psu;
//
//    @OneToOne
//    @JoinColumn(name = "cpuAirCoolingId", referencedColumnName = "cpuAirCoolingId")
//    private CpuAirCooling cpuAirCooling;
//
//    @OneToOne
//    @JoinColumn(name = "cpuLiquidCoolingId", referencedColumnName = "cpuLiquidCoolingId")
//    private CpuLiquidCooling cpuLiquidCooling;
//
//    @OneToOne
//    @JoinColumn(name = "ramId", referencedColumnName = "ramId")
//    private Ram ram;
//
//    @OneToOne
//    @JoinColumn(name = "ssdId", referencedColumnName = "ssdId")
//    private Ssd ssd;
//
//    @OneToOne
//    @JoinColumn(name = "fanId", referencedColumnName = "fanId")
//    private Fans fan;
//
//    @OneToOne
//    @JoinColumn(name = "caseId", referencedColumnName = "caseId")
//    private Cases cases;
//
//    @OneToOne
//    @JoinColumn(name = "peripheryId", referencedColumnName = "peripheryId")
//    private Periphery periphery;

}
