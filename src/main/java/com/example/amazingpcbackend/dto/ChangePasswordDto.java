package com.example.amazingpcbackend.dto;

import lombok.Data;

@Data
public class ChangePasswordDto {
    private String userId;
    private String oldPassword;
    private String newPassword;
}
