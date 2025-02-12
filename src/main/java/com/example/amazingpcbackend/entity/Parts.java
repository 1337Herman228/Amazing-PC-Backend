package com.example.amazingpcbackend.entity;

import lombok.*;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "parts")
@BsonDiscriminator("part")
public class Parts extends Product {

    private Map<String, Object> characteristics;

    @DBRef
    private Categories categories;

    @DBRef
    private Partitions partitions;

    @DBRef
    private Types types;

    public Parts(String id, String name, String image, String description, int price, Map<String, Object> characteristics, Categories category, Partitions partition, Types cpu) {
        setId(id);
        setName(name);
        setDescription(description);
        setImage(image);
        setPrice(price);
        setCharacteristics(characteristics);
        setCategories(category);
        setPartitions(partition);
        setTypes(cpu);
    }

    @Override
    public ProductType getProductType() {
        return ProductType.PART;
    }
}
