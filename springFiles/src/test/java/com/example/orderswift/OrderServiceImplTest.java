package com.example.orderswift;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.orderswift.service.Order.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.orderswift.exception.order.OrderNotFoundException;
import com.example.orderswift.model.Order;
import com.example.orderswift.repository.OrderRepository;

public class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    private Order order1;
    private Order order2;
    private List<Order> orderList;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        order1 = new Order(1, "2022-05-09", "User 1", 100.0, "New");
        order2 = new Order(2, "2022-05-10", "User 2", 200.0, "Pending");

        orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);
    }

    @Test
    public void testSaveOrder() {
        when(orderRepository.save(order1)).thenReturn(order1);
        String result = orderService.saveOrder(order1);
        assertEquals("New order has been added", result);
    }

    @Test
    public void testGetOrders() {
        when(orderRepository.findAll()).thenReturn(orderList);
        List<Order> result = orderService.getOrders();
        assertEquals(orderList, result);
    }

    @Test
    public void testGetOrderById() {
        when(orderRepository.findById(order1.getOrderId())).thenReturn(Optional.of(order1));
        Order result = orderService.getOrderById(order1.getOrderId());
        assertEquals(order1, result);

        assertThrows(OrderNotFoundException.class, () -> {
            orderService.getOrderById(999);
        });
    }

    @Test
    public void testUpdateOrder() {
        when(orderRepository.findById(order1.getOrderId())).thenReturn(Optional.of(order1));
        when(orderRepository.save(order1)).thenReturn(order1);
        Order newOrder = new Order(1, "2022-05-11", "User 3", 300.0, "Approved");
        Order result = orderService.updateOrder(newOrder, order1.getOrderId());
        assertEquals(newOrder.getOrderDate(), result.getOrderDate());
        assertEquals(newOrder.getUser(), result.getUser());
        assertEquals(newOrder.getTotalAmount(), result.getTotalAmount());
        assertEquals(newOrder.getOrderStatus(), result.getOrderStatus());

        assertThrows(OrderNotFoundException.class, () -> {
            orderService.updateOrder(newOrder, 999);
        });
    }



    @Test
    public void testDeleteOrder() {
        Integer orderId = 1;

        String result = orderService.deleteOrder(orderId);

        assertEquals("The order with the ID num " + orderId + " has been deleted sucess", result);
        verify(orderRepository, times(1)).deleteById(orderId);
    }


}