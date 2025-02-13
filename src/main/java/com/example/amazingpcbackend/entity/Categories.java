package com.example.amazingpcbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "categories")
public class Categories {

    @Id
    private String id;
    private String value; // components / periphery
    private String label; //Комплектующие / Переферия
}
