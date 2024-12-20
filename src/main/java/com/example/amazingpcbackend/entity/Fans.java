package com.example.amazingpcbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "fans")
@Accessors(chain = true)
public class Fans extends Parts{

    @Column(length = 50)
    private String fanSize; //120 мм

    @Column(length = 50)
    private String backlight; //RGB / ARGB / Без подсветки

    @Column(length = 50)
    private String fanSpeed; //500-2000 об/мин

    @Column(length = 30)
    private String airFlow; //75.7 CFM

    private float maxNoiseLevel; //31.6 дб
}
