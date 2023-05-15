package com.example.orderswift.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.example.orderswift.model.Order;
import com.example.orderswift.service.order.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAdd() {
        Order order = new Order();
        when(orderService.saveOrder(order)).thenReturn("Order saved successfully");

        String result = orderController.add(order);

        assertEquals("Order saved successfully", result);
        verify(orderService, times(1)).saveOrder(order);
    }

    @Test
    void testGetOrderById() {
        Integer orderId = 1;
        Order order = new Order();
        when(orderService.getOrderById(orderId)).thenReturn(order);

        Order result = orderController.getOrderById(orderId);

        assertEquals(order, result);
        verify(orderService, times(1)).getOrderById(orderId);
    }

    @Test
    void testGetOrders() {
        List<Order> orders = Arrays.asList(new Order(), new Order());
        when(orderService.getOrders()).thenReturn(orders);

        List<Order> result = orderController.getOrders();

        assertEquals(orders, result);
        verify(orderService, times(1)).getOrders();
    }

    @Test
    void testUpdateOrder() {
        Integer orderId = 1;
        Order existingOrder = new Order();
        Order newOrder = new Order();
        when(orderService.updateOrder(newOrder, orderId)).thenReturn(existingOrder);

        Order result = orderController.updateOrder(newOrder, orderId);

        assertEquals(existingOrder, result);
        verify(orderService, times(1)).updateOrder(newOrder, orderId);
    }

    @Test
    void testDeleteOrder() {
        Integer orderId = 1;
        when(orderService.deleteOrder(orderId)).thenReturn("Order deleted successfully");

        String result = orderController.deleteOrder(orderId);

        assertEquals("Order deleted successfully", result);
        verify(orderService, times(1)).deleteOrder(orderId);
    }
}
