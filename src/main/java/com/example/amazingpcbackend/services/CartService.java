package com.example.amazingpcbackend.services;

import com.example.amazingpcbackend.entity.*;
import com.example.amazingpcbackend.repo.CartItemsRepository;
import com.example.amazingpcbackend.repo.PcRepository;
import com.example.amazingpcbackend.repo.PurchaseItemRepository;
import com.example.amazingpcbackend.repo.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final PurchaseItemRepository purchaseItemRepository;
    private final CartItemsRepository cartItemsRepository;
    private final UsersRepository usersRepository;
    private final PcRepository pcRepository;

    public HttpStatus editPurchaseItemQuantity(String id, int quantity) {
        try {
            PurchaseItem item = purchaseItemRepository.findById(id).get();
            item.setQuantity(quantity);
            purchaseItemRepository.save(item);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    public void deletePurchaseItem(String id) {
        try {
            purchaseItemRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HttpStatus deleteCartItem(String purchaseItemId) {
        try {
            PurchaseItem purchaseItem = purchaseItemRepository.findById(purchaseItemId).get();
            cartItemsRepository.delete(cartItemsRepository.findByItem(purchaseItem).get());
            deletePurchaseItem(purchaseItemId);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    public void deleteAllCartItems() {
        cartItemsRepository.deleteAll();
    }

    public HttpStatus addCartItemsFromConfigurator(List<String> ids, String userId) {
        try {
            Users user = usersRepository.findById(userId).orElse(null);
            List<PurchaseItem> purchaseItems = purchaseItemRepository.findAllById(ids);
            return addCartItemsFromPurchaseItems(purchaseItems, user);
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    public HttpStatus addCartItemsFromPurchaseItems(List<PurchaseItem> purchaseItems, Users user) {
        try {
            purchaseItems.forEach(purchaseItem -> addCartItemFromPurchaseItem(purchaseItem, user));
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    public void deleteCartItemsWithConfiguration(String configurationId) {
        try{
            Pc pc = pcRepository.findById(configurationId).orElse(null);
            List<PurchaseItem> purchaseItem = purchaseItemRepository.findByProduct(pc);
            for (PurchaseItem purchaseItem1 : purchaseItem) {
                CartItems cartItem = cartItemsRepository.findByItem(purchaseItem1).get();
                cartItemsRepository.delete(cartItem);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addCartItemFromPurchaseItem(PurchaseItem purchaseItem, Users user) {
        CartItems cartItem = new CartItems();
        cartItem.setItem(purchaseItem);
        cartItem.setUser(user);
        cartItemsRepository.save(cartItem);
    }

}
