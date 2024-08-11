package com.example.amazingpcbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Table(name = "parts")
@Accessors(chain = true)
public class Parts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long partId;

    @Column(nullable = false, length = 130)
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

    @OneToOne
    @JoinColumn(name = "cpuId", referencedColumnName = "cpuId")
    @JsonIgnore
    private Cpu cpu;

    @OneToOne
    @JoinColumn(name = "gpuId", referencedColumnName = "gpuId")
    @JsonIgnore
    private Gpu gpu;

    @OneToOne
    @JoinColumn(name = "motherboardId", referencedColumnName = "motherboardId")
    @JsonIgnore
    private Motherboard motherboard;

    @OneToOne
    @JoinColumn(name = "psuId", referencedColumnName = "psuId")
    @JsonIgnore
    private Psu psu;

    @OneToOne
    @JoinColumn(name = "cpuAirCoolingId", referencedColumnName = "cpuAirCoolingId")
    @JsonIgnore
    private CpuAirCooling cpuAirCooling;

    @OneToOne
    @JoinColumn(name = "cpuLiquidCoolingId", referencedColumnName = "cpuLiquidCoolingId")
    @JsonIgnore
    private CpuLiquidCooling cpuLiquidCooling;

    @OneToOne
    @JoinColumn(name = "ramId", referencedColumnName = "ramId")
    @JsonIgnore
    private Ram ram;

    @OneToOne
    @JoinColumn(name = "ssdId", referencedColumnName = "ssdId")
    @JsonIgnore
    private Ssd ssd;

    @OneToOne
    @JoinColumn(name = "fanId", referencedColumnName = "fanId")
    @JsonIgnore
    private Fans fan;

    @OneToOne
    @JoinColumn(name = "caseId", referencedColumnName = "caseId")
    @JsonIgnore
    private Cases cases;

    @OneToOne
    @JoinColumn(name = "peripheryId", referencedColumnName = "peripheryId")
    @JsonIgnore
    private Periphery periphery;

}
