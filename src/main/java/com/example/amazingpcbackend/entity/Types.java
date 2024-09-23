package com.example.amazingpcbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;

@Entity
@Data
@Table(name = "types")
@Accessors(chain = true)
public class Types {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long typeId;

    @Column(unique = true, nullable = false, length = 50)
    private String typeName; // gpu/cpu/display

    @Column(unique = true, nullable = false, length = 70)
    private String alternativeName; // Видеокарта/Процессор/Монитор

    @Column(nullable = false, length = 300)
    private String typeImage; // svg
}
