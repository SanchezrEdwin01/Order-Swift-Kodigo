package com.example.orderswift.controller;

import com.example.orderswift.model.Order;
import com.example.orderswift.service.order.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Orders", description = "This endpoint makes a CRUD of the orders get into Order Swift")
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /*Create*/
    @Operation(summary = "It creates a new order")
    @PostMapping("/add")
    public String add(@Valid @RequestBody Order order) {return orderService.saveOrder(order);}

    /*Read*/
    @Operation(summary = "It gets an order by its id")
    @GetMapping("/getById/{order_id}")
    public Order getOrderById(@PathVariable Integer order_id){return orderService.getOrderById(order_id);}

    @Operation(summary = "It gets all the orders have been made")
    @GetMapping("/getOrders")
    public List<Order> getOrders(){return orderService.getOrders();}

    /*Update*/
    @Operation(summary = "It updates an order by its id")
    @PutMapping("/update/{order_id}")
    public Order updateOrder(@Valid @RequestBody Order order, @PathVariable Integer order_id){
        return orderService.updateOrder(order, order_id);
    }
    /*Delete*/
    @Operation(summary = "It deletes an order by its id")
    @DeleteMapping("/delete/{order_id}")
    public String deleteOrder(@PathVariable Integer order_id) {return orderService.deleteOrder(order_id);}
}
