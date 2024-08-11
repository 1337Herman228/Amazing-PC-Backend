package com.example.amazingpcbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Table(name = "categories")
@Accessors(chain = true)
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;

    @Column(unique = true, nullable = false, length = 70)
    private String categoryName; //Комплектующие / Переферия
}
