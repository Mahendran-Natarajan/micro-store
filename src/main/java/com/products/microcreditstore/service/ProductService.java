package com.products.microcreditstore.service;

import com.products.microcreditstore.dto.ApiResponse;
import com.products.microcreditstore.dto.BuyProductDto;
import com.products.microcreditstore.dto.OrdersDto;

public interface ProductService {
    public ApiResponse getAllProducts() throws Exception;

    public Double getTotalAmount(BuyProductDto buyProductDto);

    public OrdersDto placeOrder(BuyProductDto buyProductDto);

}
