package com.example.amazingpcbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "partitions")
public class Partitions {

    @Id
    private String id;
    private String label; // RTX 4060, 500 GB, 24"
    private String value; // RTX4060, 500GB, 24"
}
