package com.example.amazingpcbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Table(name = "pc_performance")
@Accessors(chain = true)
public class PcPerformance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pcPerformanceId;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String image2;
}
