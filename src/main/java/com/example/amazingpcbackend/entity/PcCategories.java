package com.example.amazingpcbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Table(name = "pc_categories")
@Accessors(chain = true)
public class PcCategories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pcCategoryId;

    @Column(nullable = false, length = 100)
    private String pcCategoryName; // Нет категории / Оптимальные игровые компьютеры / Кастомные компьютеры

    @Column(length = 1000)
    private String pcCategoryDescription; // Современные игровые компьютеры с процессорами Intel Core и видеокартами NVIDIA GeForce RTX предлагают идеальное сочетание производительности и стоимости. Максимум эффективности.
}
