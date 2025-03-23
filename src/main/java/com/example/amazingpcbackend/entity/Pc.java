package com.example.amazingpcbackend.entity;

import com.example.amazingpcbackend.dao.PartWithQuantity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "pc")
public class Pc extends Product {

    @DBRef
    private PcModelGroups pcModelGroup;
    @DBRef
    private PcTypes pcType;
    @DBRef
    private PcCategories pcCategories;
    @DBRef
    private Parts gpu;
    @DBRef
    private Parts cpu;
    @DBRef
    private Parts motherboard;
    @DBRef
    private Parts cpuFan;
    @DBRef
    private Parts ram;
    @DBRef
    private Parts psu;
    @DBRef
    private Parts pcCase;
    private List<PartWithQuantity> ssd;
    private List<PartWithQuantity> fans;
    @DBRef
    private Users userCreated;
    @Override
    public ProductType getProductType() {
        return ProductType.PC;
    }
}
