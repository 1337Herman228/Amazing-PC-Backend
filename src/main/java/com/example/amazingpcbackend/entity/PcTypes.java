package com.example.amazingpcbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "pc_types")
public class PcTypes {

    @Id
    private String id;
    private String typeValue; // pc/notebook/workstation/configuration
    private String typeName; // Компьютер/Ноутбук/Рабочая станция/Конфигурация
}
