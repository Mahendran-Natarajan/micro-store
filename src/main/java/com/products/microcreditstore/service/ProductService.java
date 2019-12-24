package com.products.microcreditstore.service;

import com.products.microcreditstore.dto.ApiResponse;
import com.products.microcreditstore.dto.BuyProductDto;
import com.products.microcreditstore.dto.OrdersDto;

/**
 * The interface Product service.
 */
public interface ProductService {
    /**
     * Gets all products.
     *
     * @return the all products
     * @throws Exception the exception
     */
    public ApiResponse getAllProducts() throws Exception;

    /**
     * Gets total amount.
     *
     * @param buyProductDto the buy product dto
     * @return the total amount
     */
    public Double getTotalAmount(BuyProductDto buyProductDto);

    /**
     * Place order orders dto.
     *
     * @param buyProductDto the buy product dto
     * @return the orders dto
     */
    public OrdersDto placeOrder(BuyProductDto buyProductDto);

}
