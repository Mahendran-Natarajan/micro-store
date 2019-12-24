package com.products.microcreditstore.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Transaction response dto.
 */
@Setter
@Getter
public class TransactionResponseDto {
    private Integer statuscode;
    private String message;
    private TransactionsDto transactionsDto;
}
