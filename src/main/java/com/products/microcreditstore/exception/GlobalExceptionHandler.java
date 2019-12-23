package com.products.microcreditstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * Global exception handler.
 *
 * @author Mahendran
 * @version 1.0
 * @since 20-12-2019
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    /**
     * Global exception handler response entity.
     *
     * @param exception the exception
     * @param request   the request
     * @return the response entity
     * @ExceptionHandler(value = {CustomException.class, Exception.class}) public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) { List<String> details = new ArrayList<>(); details.add(ex.getLocalizedMessage()); ApiError error = new ApiError(ex.getMessage(), HttpStatus.NOT_FOUND); return new ResponseEntity(error, HttpStatus.BAD_REQUEST); }
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> globalExceptionHandler(Exception exception, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setStatusCode(404);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
