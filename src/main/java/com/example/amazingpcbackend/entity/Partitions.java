package com.example.amazingpcbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Table(name = "partitions")
@Accessors(chain = true)
public class Partitions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long partitionId;

    @Column(unique = true, nullable = false, length = 50)
    private String partitionName; // RTX4060, 500GB, 24"
}
