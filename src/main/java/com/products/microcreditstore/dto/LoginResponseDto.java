package com.products.microcreditstore.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Login response dto.
 */
@Setter
@Getter
public class LoginResponseDto {
    private Long userId;
    private String name;
    private Integer statusCode;
    private String message;
}
