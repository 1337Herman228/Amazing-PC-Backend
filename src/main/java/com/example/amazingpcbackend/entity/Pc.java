package com.example.amazingpcbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Table(name = "pc")
@Accessors(chain = true)
public class Pc {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pcId;

    @ManyToOne
    @JoinColumn(name = "pcModelGroupId")
    private PcModelGroups pcModelGroup;

    @ManyToOne
    @JoinColumn(name = "pcTypeId")
    private PcTypes pcType;

    @ManyToOne
    @JoinColumn(name = "pcCategoryId")
    private PcCategories pcCategories;

    @Column(nullable = false, length = 70)
    private String name;

    @Column(nullable = true, length = 350)
    private String description;

    private float totalPrice;

    @ManyToOne
    @JoinColumn(name = "gpu_id")
    private Parts gpu;

    @ManyToOne
    @JoinColumn(name = "cpu_id")
    private Parts cpu;

    @ManyToOne
    @JoinColumn(name = "motherboard_id")
    private Parts motherboard;

    @ManyToOne
    @JoinColumn(name = "cpu_fan_id")
    private Parts cpuFan;

    @ManyToOne
    @JoinColumn(name = "ram_id")
    private Parts ram;

    @ManyToOne
    @JoinColumn(name = "psu_id")
    private Parts psu;

    @ManyToOne
    @JoinColumn(name = "case_id")
    private Parts pcCase;
}
