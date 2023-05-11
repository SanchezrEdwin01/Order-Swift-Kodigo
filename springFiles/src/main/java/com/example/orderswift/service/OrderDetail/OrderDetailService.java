package com.example.orderswift.service.OrderDetail;

import com.example.orderswift.model.Order;
import com.example.orderswift.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrderDetailService{

    String saveOrderDetail(OrderDetail orderDetail);

    public List<OrderDetail> getAllOrdersDetail();

    OrderDetail getOrderDetailByIdOrder(Integer id_order);

    OrderDetail updateOrderDetail(OrderDetail orderDetail, Integer id_orderDetail);

    String deleteOrderDetail(Integer id_orderDetail);

}
