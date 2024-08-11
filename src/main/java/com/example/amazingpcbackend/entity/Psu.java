package com.example.amazingpcbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Table(name = "psu")
@Accessors(chain = true)
public class Psu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long psuId;

    private int power; //650 W

    @Column(length = 15)
    private String formFactor; //ATX

    @Column(length = 20)
    private String pfc; //Активный

    @Column(length = 100)
    private String coolingSystem; //1 вентилятор (120мм)

    @Column(length = 20)
    private String mbConnector; //20+4 pin

    private int cpu4Plus4Quantity; //2
    private int gpu6Plus2Quantity; //4
    private int sataQuantity; //7

    @Column(length = 40)
    private String certificate; //80+ Bronze

    @Column(length = 40)
    private String modular; //нет / полумодульный / модульный

}
