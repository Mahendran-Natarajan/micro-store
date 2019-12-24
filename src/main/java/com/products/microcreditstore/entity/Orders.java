package com.products.microcreditstore.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * The type Orders.
 */
@Table
@Entity(name = "orders")
@Data
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    private Integer qty;
    private Long productId;
    private Double price;
    private LocalDate date;
}
