package com.example.amazingpcbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Table(name = "pc_model_groups")
@Accessors(chain = true)
public class PcModelGroups {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pcModelGroupId;

    @ManyToOne
    @JoinColumn(name = "pcTypeId")
    private PcTypes pcTypes;

    @ManyToOne
    @JoinColumn(name = "pcCategoryId")
    private PcCategories pcCategories;

    @Column(nullable = false, unique = true, length = 50)
    private String modelGroupName; //One

    @Column(nullable = false, length = 100)
    private String modelGroupDescription; //Начальный игровой компьютер

    @Column(nullable = false, length = 300)
    private String gpuDescription; //...

    @Column(nullable = false, length = 300)
    private String cpuDescription; //...

    @Column(nullable = true, length = 300)
    private String motherboardDescription; //...

    @Column(nullable = false, length = 300)
    private String ramDescription; //...

    @Column(nullable = false, length = 300)
    private String ssdDescription; //...

    @Column(nullable = true, length = 300)
    private String psuDescription; //...

    @OneToOne
    @JoinColumn(name = "pcHeaderId")
    private PcHeader pcHeader;

    @OneToOne
    @JoinColumn(name = "pcDesignId")
    private PcDesign pcDesign;

    @OneToOne
    @JoinColumn(name = "pcPreviewId")
    private PcPreview pcPreview;

    @OneToOne
    @JoinColumn(name = "pcPerformanceId")
    private PcPerformance pcPerformance;
}
