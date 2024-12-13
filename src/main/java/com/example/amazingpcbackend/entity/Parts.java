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
}
