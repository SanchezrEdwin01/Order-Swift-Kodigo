package com.example.orderswift.exception.order;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(Integer id_order) { super("Could not found the order with the id " + id_order);}
}
