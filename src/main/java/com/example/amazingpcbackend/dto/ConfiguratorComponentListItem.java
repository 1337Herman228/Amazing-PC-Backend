package com.example.amazingpcbackend.dto;

import com.example.amazingpcbackend.entity.Categories;
import com.example.amazingpcbackend.entity.Parts;
import com.example.amazingpcbackend.entity.Types;
import lombok.Data;

import java.util.List;

@Data
public class ConfiguratorComponentListItem {

    // multiselect:false,
    // default_checked:true,
    // max_quantity:0,


    // default_checked - checked по умолчанию (по дефолту стоит в true, даже если поля в объекте нет)
    // когда это значение стоит в false и элемент радиокнопка, то при выборе появляется красный крестик, нажатие на который уюирает выбор кнопки
    // multiselect:'true' - чекбоксы, если поля нет, либо false - то радиокнопки
    // max_quantity:5 - количество в select'e чекбокса

    private Types type;
    private Categories category;
    private List<String> partition;
    private List<Parts> items;
}
