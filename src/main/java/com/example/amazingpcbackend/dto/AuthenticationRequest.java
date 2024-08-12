package com.example.amazingpcbackend.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public record AuthenticationRequest (
        String login,
        String password
){
}
