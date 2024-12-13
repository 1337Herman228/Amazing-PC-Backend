package com.example.amazingpcbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "compare_items_parts")
@Accessors(chain = true)
public class CompareItemsParts extends CompareItems{

    @ManyToOne
    @JoinColumn(name = "partId")
    private Parts part;

}
