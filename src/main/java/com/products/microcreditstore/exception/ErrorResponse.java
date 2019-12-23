package com.products.microcreditstore.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * The Error response.
 */
@Setter
@Getter
public class ErrorResponse {

    private String message;
    private int statusCode;
}