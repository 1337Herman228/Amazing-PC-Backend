package com.example.amazingpcbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;
import jakarta.persistence.*;

@Entity
@Data
@Table(name = "gpu")
@Accessors(chain = true)
public class Gpu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gpuId;

    private int techProcess; // 5nm
    private int maxDisplaysQuantity; // 4

    @Column(length = 30)
    private String maxResolution; // 7680x4320

    @Column(length = 30)
    private String baseFrequency; // 2295 МГц

    @Column(length = 30)
    private String boostFrequency; // 2300 МГц

    private int vramCapacity; // 128 ГБ

    @Column(length = 30)
    private String vramType; // GDDR6X

    private int busWidth; // 320 bit
    private int hdmi; // 1
    private int displayPort; // 2
    private int cuda; //10240

    @Column(length = 35)
    private String powerConnector; //8+8 pin

    private int minPowerUnit; //850
    private int fans; //3

    @Column(length = 30)
    private String extensionSlots; //2.5

    private int length; //250
    private int width; //110
    private int height; //49.6

}
