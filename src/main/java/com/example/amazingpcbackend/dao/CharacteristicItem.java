package com.example.amazingpcbackend.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CharacteristicItem<T> {
    private String value;
    private String label;
    private T item;
}
