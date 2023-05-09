package com.example.orderswift.controller;

import com.example.orderswift.model.Order;
import com.example.orderswift.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /*Create*/
    @PostMapping("/add")
    public String add(@RequestBody Order order) {return orderService.saveOrder(order);}

    /*Read*/
    @GetMapping("/getById/{order_id}")
    public Order getOrderById(@PathVariable Integer order_id){return orderService.getOrderById(order_id);}

    @GetMapping("/getOrders")
    public List<Order> getOrders(){return orderService.getOrders();}

    /*Update*/
    @PutMapping("/update/{order_id}")
    public Order updateOrder(@RequestBody Order order, @PathVariable Integer order_id){
        return orderService.updateOrder(order, order_id);
    }
    /*Delete*/
    @DeleteMapping("/delete/{order_id}")
    public String deleteOrder(@PathVariable Integer order_id) {return orderService.deleteOrder(order_id);}
}
