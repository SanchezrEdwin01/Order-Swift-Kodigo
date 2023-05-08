package com.example.orderswift.service;

import com.example.orderswift.model.Order;
import com.example.orderswift.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServicea {
    @Autowired
    OrderRepository orderRepository;

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrder(Integer orderId) {
        return orderRepository.findById(orderId);
    }

    public void saveOrUpdate(Order order) {
        orderRepository.save(order);
    }

    public void delete(Integer orderId) {
        orderRepository.deleteById(orderId);
    }
}