package com.example.amazingpcbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Data
@Table(name = "ram")
@Accessors(chain = true)
public class Ram {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ramId;

    @Column(length = 20)
    private String type; //DDR4

    private int frequency; //3200 МГц
    private int capacity; //8 ГБ
}
