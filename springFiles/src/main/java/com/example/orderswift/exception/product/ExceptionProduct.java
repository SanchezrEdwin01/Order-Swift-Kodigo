package com.example.orderswift.exception.product;

public class ExceptionProduct extends RuntimeException {
    public ExceptionProduct(Integer productId) {
        super("Could not found the Product with the id "+ productId);
    }
}
