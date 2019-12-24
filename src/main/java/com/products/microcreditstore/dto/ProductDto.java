package com.products.microcreditstore.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Product dto.
 */
@Setter
@Getter
public class ProductDto {
    private Long productId;
    private String name;
    private Integer availableQty;
    private Double price;
    private String description;
    private Double totalAmount;
}
