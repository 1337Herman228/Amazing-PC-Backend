package com.example.amazingpcbackend.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CharacteristicValue<T> {
    private String name;
    private T value;
}
