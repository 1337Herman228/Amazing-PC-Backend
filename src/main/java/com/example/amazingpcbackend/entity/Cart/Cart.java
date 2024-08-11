package com.example.amazingpcbackend.entity.Cart;

import com.example.amazingpcbackend.entity.PurchaseItems;
import com.example.amazingpcbackend.entity.Users;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Table(name = "cart")
@Accessors(chain = true)
public class Cart {

    @EmbeddedId
    private CartId id;

    @ManyToOne
    @MapsId("userId")
    private Users user;

    @ManyToOne
    @MapsId("purchaseItemId")
    private PurchaseItems purchaseItem;
}
