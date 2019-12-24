package com.products.microcreditstore.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * The Product.
 */
@Table
@Entity(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private String name;
    private Integer availableQty;
    private Double price;
    private String description;

}
