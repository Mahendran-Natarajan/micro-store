package com.products.microcreditstore.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Api response.
 */
@Setter
@Getter
@NoArgsConstructor
public class ApiResponse {
    private String message;
    private int statusCode;
    private List<ProductDto> productDtos;
    private List<OrdersDto> orders;
    OrdersDto order;
}
