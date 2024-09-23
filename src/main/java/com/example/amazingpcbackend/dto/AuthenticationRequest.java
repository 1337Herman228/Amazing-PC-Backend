package com.example.amazingpcbackend.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public record AuthenticationRequest (

        boolean redirect,
        String csrfToken,
        String callbackUrl,
        String json,

        String login,
        String password
){
}
