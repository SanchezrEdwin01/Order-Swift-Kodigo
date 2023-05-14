package com.example.orderswift.exception.product;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ProductNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler({ExceptionProduct.class, ExceptionProduct.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> exceptionHandler(RuntimeException exception){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("Error message: ", exception.getMessage());
        return errorMap;
    }
}
