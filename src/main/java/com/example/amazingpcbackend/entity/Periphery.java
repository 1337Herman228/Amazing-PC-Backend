package com.example.amazingpcbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Table(name = "periphery")
@Accessors(chain = true)
public class Periphery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long peripheryId;

    @Column(columnDefinition = "json")
    private String characteristics;

}
