package com.example.amazingpcbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Table(name = "pc_preview")
@Accessors(chain = true)
public class PcPreview {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pcPreviewId;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false)
    private String mainImage;

    @Column(columnDefinition = "json")
    private String sliderImages;
}
