package com.example.amazingpcbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "pc_categories")
public class PcCategories {
    @Id
    private String id;
    private String pcCategoryValue; // none / optimal-gaming-pc / custom-pc
    private String pcCategoryName; // Нет категории / Оптимальные игровые компьютеры / Кастомные компьютеры
    private String pcCategoryDescription;
}
