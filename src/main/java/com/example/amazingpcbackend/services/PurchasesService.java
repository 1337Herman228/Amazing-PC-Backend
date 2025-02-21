package com.example.amazingpcbackend.services;

import com.example.amazingpcbackend.entity.CartItems;
import com.example.amazingpcbackend.entity.PurchaseItem;
import com.example.amazingpcbackend.entity.Users;
import com.example.amazingpcbackend.repo.CartItemsRepository;
import com.example.amazingpcbackend.repo.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchasesService {

        private  final UsersRepository usersRepository;
        private  final CartItemsRepository cartItemsRepository;

    public List<PurchaseItem> getUserCartItems(String userId){
        Users user = usersRepository.findById(userId).orElse(null);
        List<CartItems> cartItems = cartItemsRepository.findByUser(user);

        return cartItems.stream()
                .map(CartItems::getItem)
                .toList();
    }

}
