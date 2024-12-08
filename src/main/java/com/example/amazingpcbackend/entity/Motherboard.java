package com.example.amazingpcbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import jakarta.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "motherboard")
@Accessors(chain = true)
public class Motherboard extends Parts{

    @Column(length = 30)
    private String socket; //lga 1700

    @Column(length = 20)
    private String formFactor; //ATX

    @Column(length = 20)
    private String chipset; //Z790

    @Column(length = 20)
    private String ramType; //DDR5

    private int ramSlots; //4
    private int maxRamCapacity; //192 GB
    private int sataQuantity; //6
    private int m2Quantity; //4
    private int pcie16Quantity; //2
}
