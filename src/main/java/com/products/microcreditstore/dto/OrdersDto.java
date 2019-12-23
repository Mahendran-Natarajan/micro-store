package com.products.microcreditstore.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class OrdersDto {
    private Long orderId;
    private Integer qty;
    private Long productId;
    private Double price;
    private LocalDate date;
}
