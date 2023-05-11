package com.example.orderswift.exception.product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExceptionProduct extends RuntimeException {
    public ExceptionProduct(Integer productId) {
        super("Could not found the Product with the id "+ productId);
    }
}
