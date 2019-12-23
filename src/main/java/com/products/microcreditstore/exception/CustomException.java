package com.products.microcreditstore.exception;

/**
 * The Custom exception.
 */
public class CustomException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new Custom exception.
     */
    public CustomException() {
        super();
    }

    /**
     * Instantiates a new Custom exception.
     *
     * @param msg the msg
     */
    public CustomException(String msg) {
        super(msg);
    }

}
