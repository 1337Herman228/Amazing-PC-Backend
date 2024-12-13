package com.example.amazingpcbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Table(name = "purchase_items")
@Accessors(chain = true)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PurchaseItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long purchaseItemId;

    private int quantity; //3
    private float totalPrice; //12000

    @ManyToOne
    @JoinColumn(name = "purchaseId")
    private Purchases purchase;
}
