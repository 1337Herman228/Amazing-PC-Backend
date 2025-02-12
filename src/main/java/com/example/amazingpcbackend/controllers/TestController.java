package com.example.amazingpcbackend.controllers;

import com.example.amazingpcbackend.entity.*;
import com.example.amazingpcbackend.repo.*;
import com.example.amazingpcbackend.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final PcRepository pcRepository;
    private final PurchaseItemRepository purchaseItemRepository;
    private final PurchasesRepository purchasesRepository;
    private final CartItemsRepository cartItemsRepository;
    private final CompareItemsRepository compareItemsRepository;

    @GetMapping("/pc")
    public List<Pc> getPc() {
       return pcRepository.findAll();
    }

    @GetMapping("/purchase_items")
    public List<PurchaseItem> getPurchaseItems() {
        return purchaseItemRepository.findAll();
    }

    @GetMapping("/purchases")
    public List<Purchases> getPurchases() {
        return purchasesRepository.findAll();
    }

    @GetMapping("/cart")
    public List<CartItems> getCartItems() {
        return cartItemsRepository.findAll();
    }

    @GetMapping("/compare")
    public List<CompareItems> getCompare() {
        return compareItemsRepository.findAll();
    }

}