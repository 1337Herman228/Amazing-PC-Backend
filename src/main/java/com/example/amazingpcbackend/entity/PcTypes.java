package com.example.amazingpcbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Table(name = "pc_types")
@Accessors(chain = true)
public class PcTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pcTypeId;

    @Column(nullable = false, length = 50)
    private String type; // pc/notebook/workstation/configuration
}
