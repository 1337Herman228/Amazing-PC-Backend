package com.example.amazingpcbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "ram")
@Accessors(chain = true)
public class Ram extends Parts{

    @Column(length = 20)
    private String type; //DDR4

    private int frequency; //3200 МГц
    private int capacity; //8 ГБ
}
