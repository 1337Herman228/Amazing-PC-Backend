package com.example.amazingpcbackend.services;

import com.example.amazingpcbackend.entity.Cart.Cart;
import com.example.amazingpcbackend.entity.PurchaseItems;
import com.example.amazingpcbackend.entity.Users;
import com.example.amazingpcbackend.repo.CartRepository;
import com.example.amazingpcbackend.repo.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchasesService {

    private final CartRepository cartRepository;
    private final UsersRepository usersRepository;

    public List<PurchaseItems> getUserCartItems(Long userId){

        Users user = usersRepository.findById(userId).orElse(null);
        List<Cart> cartItems = cartRepository.findByUser(user);

        return cartItems.stream()
                .map(Cart::getPurchaseItem)
                .toList();
    }

}
