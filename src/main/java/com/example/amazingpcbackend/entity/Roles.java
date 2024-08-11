package com.example.amazingpcbackend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleId;

    @Column(length = 30)
    private String position;
}
