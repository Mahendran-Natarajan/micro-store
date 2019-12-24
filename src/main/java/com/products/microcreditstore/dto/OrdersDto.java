package com.products.microcreditstore.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * The type Orders dto.
 */
@Setter
@Getter
public class OrdersDto {
    private Long orderId;
    private Integer qty;
    private Long productId;
    private Double price;
    private LocalDate date;
}
