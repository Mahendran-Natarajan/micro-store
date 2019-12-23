package com.products.microcreditstore.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class BuyProductDto {
    LocalDate expiryDate;
    List<ProductDto> products;
    private Long userId;
    private Long cardNumber;
    private Integer cvvNumber;
    private Integer otp;
}
