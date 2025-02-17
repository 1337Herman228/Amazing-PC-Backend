package com.example.amazingpcbackend.services.impl;

import com.example.amazingpcbackend.dto.AuthenticationRequest;
import com.example.amazingpcbackend.dto.AuthenticationResponse;
import com.example.amazingpcbackend.dto.NewUserDto;
import com.example.amazingpcbackend.entity.Roles;
import com.example.amazingpcbackend.entity.Users;
import com.example.amazingpcbackend.repo.RolesRepository;
import com.example.amazingpcbackend.repo.UsersRepository;
import com.example.amazingpcbackend.security.MyUserDetails;
import com.example.amazingpcbackend.services.AuthenticationService;
import com.example.amazingpcbackend.services.JwtService;
import com.example.amazingpcbackend.services.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final MyUserDetailsService userDetailsService;

    private final AuthenticationManager authenticationManager;

    private final UsersRepository userRepository;
    private final RolesRepository rolesRepository;

    @Override
    public AuthenticationResponse register(NewUserDto newUser) {
        String login = newUser.getLogin();

        if (userRepository.findByLogin(login).isPresent()) {
            throw new RuntimeException("User with login: %s already exists".formatted(login));
        }

        Roles role = rolesRepository.findByValue("user").orElseThrow();
        Users user = new Users()
                .setPassword(passwordEncoder.encode(newUser.getPassword()))
                .setLogin(login)
                .setRoles(role)
                .setName(newUser.getName())
                .setSurname(newUser.getSurname())
                .setPhone(newUser.getPhone())
                .setEmail(newUser.getEmail());
        userRepository.save(user);
        String token = jwtService.generateToken(new MyUserDetails(user));
        return new AuthenticationResponse(token);
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.login(),
                        authenticationRequest.password()
                )
        );
        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.login());
        String token = jwtService.generateToken(userDetails);
        return new AuthenticationResponse(token);
    }
}
