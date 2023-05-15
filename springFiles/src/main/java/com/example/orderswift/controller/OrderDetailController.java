package com.example.orderswift.controller;


import com.example.orderswift.model.OrderDetail;
import com.example.orderswift.service.orderdetail.OrderDetailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Order detail", description = "This controller makes a CRUD of the order details")
@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    /*Create*/
    @Operation(summary = "It creates a new order detail")
    @PostMapping("/add")
    public String add(@RequestBody OrderDetail orderDetail) {return orderDetailService.saveOrderDetail(orderDetail);}

    /*Read*/
    @Operation(summary = "It gets an order by id order")
    @GetMapping("/getById/{order_id}")
    public OrderDetail getOrderDetailByIdOrder(@PathVariable Integer order_id){return orderDetailService.getOrderDetailByIdOrder(order_id);}

    @Operation(summary = "It gets all the orders detail have been made")
    @GetMapping("/getDetails")
    public List<OrderDetail> getAllOrdersDetail(){return orderDetailService.getAllOrdersDetail();}

    /*Update*/
    @Operation(summary = "It updates an order detail by order id")
    @PutMapping("/update/{order_id}")
    public OrderDetail updateOrderDetail(@RequestBody OrderDetail orderDetail, @PathVariable Integer orderDetail_id){
        return orderDetailService.updateOrderDetail(orderDetail, orderDetail_id);
    }

    /*Delete*/
    @Operation(summary = "It deletes an order by order id")
    @DeleteMapping("/delete/{order_id}")
    public String deleteOrderDetail(@PathVariable Integer orderDetail_id) {return orderDetailService.deleteOrderDetail(orderDetail_id);}
}
