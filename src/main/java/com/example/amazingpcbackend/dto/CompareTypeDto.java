package com.example.amazingpcbackend.dto;

import lombok.Data;

@Data
public class CompareTypeDto {
    private String id;
    private String value;
    private String label;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompareTypeDto that)) return false;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
