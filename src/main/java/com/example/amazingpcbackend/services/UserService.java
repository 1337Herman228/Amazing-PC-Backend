package com.example.amazingpcbackend.services;

import com.example.amazingpcbackend.dto.NewUserDto;
import com.example.amazingpcbackend.entity.Roles;
import com.example.amazingpcbackend.entity.Types;
import com.example.amazingpcbackend.entity.Users;
import com.example.amazingpcbackend.repo.RolesRepository;
import com.example.amazingpcbackend.repo.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final RolesRepository rolesRepository;
    private final UsersRepository usersRepository;

    public HttpStatus addUser(NewUserDto newUserDto) {
        try {
            Users user = new Users();
            usersRepository.save(makeUserFromDto(user, newUserDto));
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    public HttpStatus editUser(NewUserDto newUserDto) {
        try {
            Users user = makeUserFromDto(usersRepository.findById(newUserDto.getId()).get(), newUserDto);
            usersRepository.save(user);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    public HttpStatus deleteUser(String id) {
        try {
            usersRepository.deleteById(id);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    public Users makeUserFromDto(Users editableUser, NewUserDto newUser) {
        Roles role = rolesRepository.findById(newUser.getRoleId()).orElseThrow();
        editableUser.setLogin(newUser.getLogin());
        editableUser.setPassword( passwordEncoder.encode(newUser.getPassword()));
        editableUser.setName(newUser.getName());
        editableUser.setSurname(newUser.getSurname());
        editableUser.setPhone(newUser.getPhone());
        editableUser.setEmail(newUser.getEmail());
        editableUser.setRoles(role);
        return editableUser;
    }
}
