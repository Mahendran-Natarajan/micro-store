package com.products.microcreditstore.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

/**
 * The type Buy product dto.
 */
@Setter
@Getter
public class BuyProductDto {
    /**
     * The Expiry date.
     */
    LocalDate expiryDate;
    /**
     * The Products.
     */
    List<ProductDto> products;
    private Long userId;
    private Long cardNumber;
    private Integer cvvNumber;
    private Integer otp;
}
