package com.example.amazingpcbackend.dto;

import lombok.Data;

@Data
public class UserInfoDto {
    private String login;
    private String name;
    private String surname;
    private String phone;
    private String email;
}
