package com.example.amazingpcbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class NewUserDto {
    private String login;
    private String password;
    private final String position = "Пользователь";
    private String name;
    private String surname;
    private String phone;
    private String email;
}
