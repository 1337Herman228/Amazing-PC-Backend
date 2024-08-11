package com.example.amazingpcbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Table(name = "compare_items")
@Accessors(chain = true)
public class CompareItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long compareItemId;

    @ManyToOne
    @JoinColumn(name = "partId")
    private Parts part;

    @ManyToOne
    @JoinColumn(name = "pcId")
    private Pc pc;
}
