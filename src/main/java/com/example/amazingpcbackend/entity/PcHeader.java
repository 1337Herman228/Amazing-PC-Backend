package com.example.amazingpcbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Table(name = "pc_header")
@Accessors(chain = true)
public class PcHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pcHeaderId;

    @Column(nullable = false, length = 450)
    private String description;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String imageMobile;
}
