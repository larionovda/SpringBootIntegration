package com.larionov.epam.exception;

public class ProductNotFoundException extends RuntimeException{
    ProductNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
