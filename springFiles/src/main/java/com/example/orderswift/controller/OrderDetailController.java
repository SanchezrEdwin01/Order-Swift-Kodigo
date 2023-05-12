package com.example.orderswift.controller;


import com.example.orderswift.model.OrderDetail;
import com.example.orderswift.service.orderdetail.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    /*Create*/
    @PostMapping("/add")
    public String add(@RequestBody OrderDetail orderDetail) {return orderDetailService.saveOrderDetail(orderDetail);}

    /*Read*/
    @GetMapping("/getById/{order_id}")
    public OrderDetail getOrderDetailByIdOrder(@PathVariable Integer order_id){return orderDetailService.getOrderDetailByIdOrder(order_id);}

    @GetMapping("/getDetails")
    public List<OrderDetail> getAllOrdersDetail(){return orderDetailService.getAllOrdersDetail();}

    /*Update*/
    @PutMapping("/update/{orderDetail_id}")
    public OrderDetail updateOrderDetail(@RequestBody OrderDetail orderDetail, @PathVariable Integer orderDetail_id){
        return orderDetailService.updateOrderDetail(orderDetail, orderDetail_id);
    }

    /*Delete*/
    @DeleteMapping("/delete/{orderDetail_id}")
    public String deleteOrderDetail(@PathVariable Integer orderDetail_id) {return orderDetailService.deleteOrderDetail(orderDetail_id);}
}
