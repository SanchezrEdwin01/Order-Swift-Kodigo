package com.example.orderswift.service;

import com.example.orderswift.Exception.OrderNotFoundException;
import com.example.orderswift.model.Order;
import com.example.orderswift.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public String saveOrder(Order order){
        orderRepository.save(order);
        return "New order has been added";
    }

    @Override
    public List<Order> getOrders(){return orderRepository.findAll();}

    @Override
    public Order getOrderById(Integer id_order) {
        return orderRepository.findById(id_order).orElseThrow(()-> new OrderNotFoundException(id_order));
    }

    @Override
    public Order updateOrder(Order newOrder, Integer id_order) {
        return orderRepository.findById(id_order).map(order -> {
            order.setOrderDate(newOrder.getOrderDate());
            order.setUser(newOrder.getUser());
            order.setTotalAmount(newOrder.getTotalAmount());
            order.setOrderStatus(newOrder.getOrderStatus());
            return orderRepository.save(order);
        }).orElseThrow(()->new  OrderNotFoundException(id_order));
    }

    @Override
    public String deleteOrder(Integer id_order) {
        orderRepository.deleteById(id_order);
        return "The order with ID num " + id_order + " has been deleted sucess";
    }
}
