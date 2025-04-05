package com.example.amazingpcbackend.entity;

import lombok.Getter;

@Getter
public enum PurchaseStatus {
    CREATED("CREATED","Создан"),
    PENDING("PENDING", "Обрабатывается"),
    DELIVERING("DELIVERING", "В пути"),
    DELIVERED("DELIVERED", "Доставлен"),
    COMPLETED("COMPLETED", "Принят"),
    CANCELED("CANCELED", "Отменен");

    private final String value;
    private final String label;

    PurchaseStatus(String value, String label) {
        this.value = value;
        this.label = label;
    }

}