package com.example.amazingpcbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Table(name = "pc_design")
@Accessors(chain = true)
public class PcDesign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pcDesignId;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 450)
    private String description;

    @Column(nullable = false)
    private String image;
}
