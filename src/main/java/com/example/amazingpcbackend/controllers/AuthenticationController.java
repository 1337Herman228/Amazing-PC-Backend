package com.example.amazingpcbackend.controllers;

import com.example.amazingpcbackend.dto.AuthDto;
import com.example.amazingpcbackend.dto.AuthenticationRequest;
import com.example.amazingpcbackend.dto.AuthenticationResponse;
import com.example.amazingpcbackend.dto.NewUserDto;
import com.example.amazingpcbackend.exceptions.AuthenticationException;
import com.example.amazingpcbackend.repo.UsersRepository;
import com.example.amazingpcbackend.services.AuthenticationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UsersRepository userRepository;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthenticationResponse register(@RequestBody String requestBody) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        NewUserDto newUser = objectMapper.readValue(requestBody, NewUserDto.class);
        try{
            return authenticationService.register(newUser);
        }
        catch (Exception e){
            return new AuthenticationResponse("user already exists");
        }
    }

    @PostMapping("/authenticate")
    @ResponseStatus(HttpStatus.OK)
    public AuthDto authenticate(@RequestBody String requestBody) throws JsonProcessingException, AuthenticationException {
        ObjectMapper objectMapper = new ObjectMapper();
        AuthenticationRequest authenticationRequest = objectMapper.readValue(requestBody, AuthenticationRequest.class);
        try{
            AuthenticationResponse authenticationResponse = authenticationService.authenticate(authenticationRequest);
            AuthDto authDto = new AuthDto();
            authDto.setAuthenticationResponse(authenticationResponse);
            authDto.setRole(userRepository.findByLogin(authenticationRequest.login()).orElseThrow().getRoles().getPosition());
            authDto.setUserId(userRepository.findByLogin(authenticationRequest.login()).orElseThrow().getUserId());
            return authDto;

        }catch (Exception e){
            throw new AuthenticationException("can't authenticate", e);
        }
    }
}