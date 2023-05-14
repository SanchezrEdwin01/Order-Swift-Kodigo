package com.example.orderswift.service.orderdetail;

import com.example.orderswift.model.OrderDetail;

import java.util.List;

public interface OrderDetailService{

    String saveOrderDetail(OrderDetail orderDetail);

    public List<OrderDetail> getAllOrdersDetail();

    OrderDetail getOrderDetailByIdOrder(Integer id_order);

    OrderDetail updateOrderDetail(OrderDetail orderDetail, Integer id_orderDetail);

    String deleteOrderDetail(Integer id_orderDetail);

}
