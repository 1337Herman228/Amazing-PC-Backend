package com.example.amazingpcbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "purchases")
public class Purchases {
    @Id
    private String id;
    private Date date;
    private String destination;

    private PurchaseStatus status;

    @DBRef
    private Users user;

    private List<PurchaseItem> itemList;
}
