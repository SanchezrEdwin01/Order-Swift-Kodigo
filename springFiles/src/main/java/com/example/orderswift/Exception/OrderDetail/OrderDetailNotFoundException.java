package com.example.orderswift.Exception.OrderDetail;

import com.example.orderswift.Exception.Order.OrderNotFoundException;

public class OrderDetailNotFoundException extends RuntimeException{
    public OrderDetailNotFoundException(Integer id_orderDetail) {super("Could not found the order detail with the id " + id_orderDetail);}
}
