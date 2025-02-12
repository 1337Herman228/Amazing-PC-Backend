package com.example.amazingpcbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "compare_items")
@CompoundIndexes({
        @CompoundIndex(name = "unique_compare_item_id", def = "{'user.id': 1, 'product.id': 1}", unique = true)
})
public class CompareItems {
    @Id
    private String id;

    @DBRef
    private Users user;

    @DBRef
    private Product product;
}
