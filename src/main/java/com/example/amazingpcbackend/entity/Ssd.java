package com.example.amazingpcbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Table(name = "ssd")
@Accessors(chain = true)
public class Ssd {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ssdId;

    @Column(length = 30)
    private String formFactor; //M2 NVME

    @Column(length = 30)
    private String capacity; //500 ГБ

    @Column(length = 30)
    private String flashMemoryType; //3d Nand

    @Column(length = 50)
    private String controllerType; //Samsung Phoenix

    private int writeVelocity; //3300 МБ/с
    private int readVelocity; //3500 МБ/с
    private int randomWriteSpeed; //560000 IOPS

    @Column(length = 40)
    private String connectionType; //PCI-E 3.0 x4

    @Column(length = 50)
    private String mtbfTime; //1500000 часов

    @Column(length = 40)
    private String maxTemperature; //70 °С

}
