package com.example.amazingpcbackend.dao;

import com.example.amazingpcbackend.entity.Parts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class    PartWithQuantity {
    private int quantity;
    private Parts part;
}
