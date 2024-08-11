package com.example.amazingpcbackend.entity.Compare;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class CompareId implements Serializable {
    private Long userId;
    private Long compareItemId;
}