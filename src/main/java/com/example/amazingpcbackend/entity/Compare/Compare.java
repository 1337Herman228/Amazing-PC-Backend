package com.example.amazingpcbackend.entity.Compare;

import com.example.amazingpcbackend.entity.CompareItems;
import com.example.amazingpcbackend.entity.Users;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Table(name = "compare")
@Accessors(chain = true)
public class Compare {

    @EmbeddedId
    private CompareId id;

    @ManyToOne
    @MapsId("userId")
    private Users user;

    @ManyToOne
    @MapsId("compareItemId")
    private CompareItems compareItem;
}
