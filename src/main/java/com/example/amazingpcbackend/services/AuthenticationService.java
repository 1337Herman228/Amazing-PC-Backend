package com.example.amazingpcbackend.services;

import com.example.amazingpcbackend.dto.AuthenticationRequest;
import com.example.amazingpcbackend.dto.AuthenticationResponse;
import com.example.amazingpcbackend.dto.NewUserDto;

public interface AuthenticationService {

    AuthenticationResponse register(NewUserDto newUserDao);

    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
}