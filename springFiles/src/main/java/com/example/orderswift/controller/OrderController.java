package com.example.orderswift.controller;

import com.example.orderswift.model.Order;
import com.example.orderswift.service.OrderServicea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderServicea orderService;

    @GetMapping
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody Order order) {
        orderService.saveOrUpdate(order);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
