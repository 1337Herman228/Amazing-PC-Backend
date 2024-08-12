package com.example.amazingpcbackend.dto;

import lombok.Data;

@Data
public class AuthDto {
    private AuthenticationResponse authenticationResponse;
    private String role;
    private Long userId;
}
