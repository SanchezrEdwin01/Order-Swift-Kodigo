package com.example.orderswift.exception.orderdetail;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class OrderDetailNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(OrderDetailNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> excetionHandler(RuntimeException exception){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("Error message", exception.getMessage());
        return errorMap;
    }
}
