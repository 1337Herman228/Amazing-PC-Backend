package com.example.amazingpcbackend.services;

import com.example.amazingpcbackend.dto.CompareTypeDto;
import com.example.amazingpcbackend.dto.ConfiguratorProductsDto;
import com.example.amazingpcbackend.dto.PartIdWithQuantity;
import com.example.amazingpcbackend.dto.PcIdWithQuantity;
import com.example.amazingpcbackend.entity.*;
import com.example.amazingpcbackend.repo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PurchasesService {

    private final UsersRepository usersRepository;
    private final CartItemsRepository cartItemsRepository;
    private final PurchaseItemRepository purchaseItemRepository;
    private final PartsRepository partsRepository;
    private final PcRepository pcRepository;
    private final PurchasesRepository purchasesRepository;
    private final CartService cartService;

    public List<Purchases> getAllPurchases(Users user) {
        try{
            return purchasesRepository.findByUser(user).stream()
                    .filter(purchases -> !purchases.getStatus().equals(PurchaseStatus.CANCELED))
                    .filter(purchases -> !purchases.getStatus().equals(PurchaseStatus.COMPLETED))
                    .collect(Collectors.toList());
        }catch(Exception e) {
            return null;

        }
    }

    public List<PurchaseItem> getUserCartItems(String userId) {
        Users user = usersRepository.findById(userId).orElse(null);
        List<CartItems> cartItems = cartItemsRepository.findByUser(user);

        return cartItems.stream()
                .map(CartItems::getItem)
                .toList();
    }

    public List<String> addConfiguratorProductsToPurchaseItems(ConfiguratorProductsDto productsDto) {
        List<String> ids = new ArrayList<>();
        try {
            ids.add(addPurchaseItemPc(productsDto.getPc()));
            ids.addAll(addPurchaseItemsParts(productsDto.getParts()));
            return ids;
        } catch (Exception e) {
            return null;
        }
    }


    public List<String> addPurchaseItemsParts(List<PartIdWithQuantity> partIdWithQuantityList) {
        List<String> ids = new ArrayList<>();
        try {
            for (PartIdWithQuantity partIdWithQuantity : partIdWithQuantityList) {
                ids.add(addPurchaseItemPart(partIdWithQuantity));
            }
            return ids;
        } catch (Exception e) {
            return null;
        }
    }

    public List<String> addPurchaseItemsPcs(List<PcIdWithQuantity> pcIdWithQuantityList) {
        List<String> ids = new ArrayList<>();
        try {
            for (PcIdWithQuantity pcIdWithQuantity : pcIdWithQuantityList) {
                ids.add(addPurchaseItemPc(pcIdWithQuantity));
            }
            return ids;
        } catch (Exception e) {
            return null;
        }
    }

    public String addPurchaseItemPart(PartIdWithQuantity partIdWithQuantity) {
        PurchaseItem purchaseItem = new PurchaseItem().setProduct(
                        partsRepository.findById(partIdWithQuantity.getPartId()).get())
                .setQuantity(partIdWithQuantity.getQuantity());
        purchaseItemRepository.save(purchaseItem);
        return purchaseItem.getId();
    }

    public String addPurchaseItemPc(PcIdWithQuantity pcIdWithQuantity) {
        PurchaseItem purchaseItem = new PurchaseItem().setProduct(
                        pcRepository.findById(pcIdWithQuantity.getPcId()).get())
                .setQuantity(pcIdWithQuantity.getQuantity());
        purchaseItemRepository.save(purchaseItem);
        return purchaseItem.getId();
    }

    public String addPurchaseItem(String productId, int quantity) {
        if (pcRepository.findById(productId).isPresent()) {
            Pc pc = pcRepository.findById(productId).get();
            PurchaseItem purchaseItem = new PurchaseItem();
            purchaseItem.setProduct(pc).setQuantity(quantity);
            purchaseItemRepository.save(purchaseItem);
            return purchaseItem.getId();
        }
        if (partsRepository.findById(productId).isPresent()) {
            Parts part = partsRepository.findById(productId).get();
            PurchaseItem purchaseItem = new PurchaseItem();
            purchaseItem.setProduct(part).setQuantity(quantity);
            purchaseItemRepository.save(purchaseItem);
            return purchaseItem.getId();
        }
        return null;
    }

    public HttpStatus createPurchase(Users user, String destination) {
        try {
            List<CartItems> cartItems = cartItemsRepository.findByUser(user);
            if (cartItems.isEmpty())
                return HttpStatus.OK;
            List<PurchaseItem> purchaseItems = cartItems.stream().map(CartItems::getItem).toList();
            Purchases purchase = new Purchases();
            purchase.setUser(user);
            purchase.setStatus(PurchaseStatus.CREATED);
            purchase.setDate(new Date());
            purchase.setDestination(destination);
            purchase.setItemList(purchaseItems);
            purchasesRepository.save(purchase);

            cartService.deleteAllCartItems();

            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }


    public HttpStatus cancelPurchase(String purchaseId) {
        try {
            Purchases purchase = purchasesRepository.findById(purchaseId).get();
            purchase.setStatus(PurchaseStatus.CANCELED);
            purchasesRepository.save(purchase);

            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    public HttpStatus deletePurchase(String purchaseId) {
        try {
            Purchases purchase = purchasesRepository.findById(purchaseId).get();
            purchasesRepository.delete(purchase);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

//    public HttpStatus editPurchase(String purchaseId, Purchases purchase){
//        try {
//            Purchases purchase = purchasesRepository.findById(purchaseId).get();
//            purchasesRepository.delete(purchase);
//            return HttpStatus.OK;
//        } catch (Exception e) {
//            return HttpStatus.INTERNAL_SERVER_ERROR;
//        }
//    }

}
