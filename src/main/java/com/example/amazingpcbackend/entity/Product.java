package com.example.amazingpcbackend.entity;

import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "products")
@BsonDiscriminator("product_type")
public abstract class Product {

    @Id
    private String id;

    private String name;
    private String description;
    private float price;
    private String image;

    @Field("product_type")
    private String productType;

    public abstract ProductType getProductType();

}

