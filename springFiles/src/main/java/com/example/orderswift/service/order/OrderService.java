package com.example.orderswift.service.order;

import com.example.orderswift.model.Order;

import java.util.List;


public interface OrderService {

    String saveOrder(Order order);

    public List<Order> getOrders();

    Order getOrderById(Integer id_order);

    Order updateOrder(Order newOrder, Integer id_order);

    String deleteOrder(Integer id_order);
}
