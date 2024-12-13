package com.example.amazingpcbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Table(name = "compare_items")
@Accessors(chain = true)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CompareItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long compareItemId;

}
