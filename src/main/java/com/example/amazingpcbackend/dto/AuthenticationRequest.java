package com.example.amazingpcbackend.dto;

public record AuthenticationRequest (

        boolean redirect,
        String csrfToken,
        String callbackUrl,
        String json,

        String login,
        String password
){
}
