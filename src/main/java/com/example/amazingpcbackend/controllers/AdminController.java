package com.example.amazingpcbackend.controllers;

import com.example.amazingpcbackend.entity.Parts;
import com.example.amazingpcbackend.repo.PartsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('admin')")
@RequiredArgsConstructor
public class AdminController {

    private final PartsRepository partsRepository;

    @GetMapping("/parts")
    public List<Parts> products() {
        return partsRepository.findAll();
    }
}
