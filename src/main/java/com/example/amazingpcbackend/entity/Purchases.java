package com.example.amazingpcbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Entity
@Data
@Table(name = "purchases")
@Accessors(chain = true)
public class Purchases {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long purchaseId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Users users;

    @Column(nullable = false, length = 500)
    private String destination; //г. Минск ...

    @Column(nullable = false)
    private Date date;
}
