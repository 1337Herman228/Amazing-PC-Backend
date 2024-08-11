package com.example.amazingpcbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Table(name = "pc_ssd_quantity")
@Accessors(chain = true)
public class PcSsdQuantity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pc_id", nullable = false)
    private Pc pc;

    @ManyToOne
    @JoinColumn(name = "ssd_id", nullable = false)
    private Parts ssd;

    @Column(name = "quantity", nullable = false)
    private int quantity;
}
