package com.example.amazingpcbackend.dao.converters;

import com.example.amazingpcbackend.dao.RamType;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RamTypeConverter implements AttributeConverter<RamType, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(RamType ramType) {
        try {
            return ramType != null ? objectMapper.writeValueAsString(ramType) : null;
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert RamType to JSON", e);
        }
    }

    @Override
    public RamType convertToEntityAttribute(String json) {
        try {
            return json != null ? objectMapper.readValue(json, RamType.class) : null;
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert JSON to RamType", e);
        }
    }
}