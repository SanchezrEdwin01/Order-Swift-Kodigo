package com.example.orderswift.Exception.Order;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(Integer id_order) { super("Could not found the order with the id " + id_order);}
}
