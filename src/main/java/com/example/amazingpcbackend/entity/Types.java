package com.example.amazingpcbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "types")
public class Types {

    @Id
    private String id;
    private String typeValue; // gpu/cpu/display
    private String typeName;  // Видеокарта/Процессор/Монитор
    private String typeImage; // svg
}
