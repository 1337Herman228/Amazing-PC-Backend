package com.example.amazingpcbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "periphery")
@Accessors(chain = true)
public class Periphery extends Parts{

    //JSON
    private String characteristics;

}
