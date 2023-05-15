package com.example.orderswift.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.example.orderswift.model.OrderDetail;
import com.example.orderswift.service.orderdetail.OrderDetailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OrderDetailControllerTest {

    @Mock
    private OrderDetailService orderDetailService;

    @InjectMocks
    private OrderDetailController orderDetailController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAdd() {
        OrderDetail orderDetail = new OrderDetail();
        when(orderDetailService.saveOrderDetail(orderDetail)).thenReturn("Order detail saved successfully");

        String result = orderDetailController.add(orderDetail);

        assertEquals("Order detail saved successfully", result);
        verify(orderDetailService, times(1)).saveOrderDetail(orderDetail);
    }

    @Test
    void testGetOrderDetailByIdOrder() {
        Integer orderId = 1;
        OrderDetail orderDetail = new OrderDetail();
        when(orderDetailService.getOrderDetailByIdOrder(orderId)).thenReturn(orderDetail);

        OrderDetail result = orderDetailController.getOrderDetailByIdOrder(orderId);

        assertEquals(orderDetail, result);
        verify(orderDetailService, times(1)).getOrderDetailByIdOrder(orderId);
    }

    @Test
    void testGetAllOrdersDetail() {
        List<OrderDetail> orderDetails = Arrays.asList(new OrderDetail(), new OrderDetail());
        when(orderDetailService.getAllOrdersDetail()).thenReturn(orderDetails);

        List<OrderDetail> result = orderDetailController.getAllOrdersDetail();

        assertEquals(orderDetails, result);
        verify(orderDetailService, times(1)).getAllOrdersDetail();
    }

    @Test
    void testUpdateOrderDetail() {
        Integer orderDetailId = 1;
        OrderDetail existingOrderDetail = new OrderDetail();
        OrderDetail newOrderDetail = new OrderDetail();
        when(orderDetailService.updateOrderDetail(newOrderDetail, orderDetailId)).thenReturn(existingOrderDetail);

        OrderDetail result = orderDetailController.updateOrderDetail(newOrderDetail, orderDetailId);

        assertEquals(existingOrderDetail, result);
        verify(orderDetailService, times(1)).updateOrderDetail(newOrderDetail, orderDetailId);
    }

    @Test
    void testDeleteOrderDetail() {
        Integer orderDetailId = 1;
        when(orderDetailService.deleteOrderDetail(orderDetailId)).thenReturn("Order detail deleted successfully");

        String result = orderDetailController.deleteOrderDetail(orderDetailId);

        assertEquals("Order detail deleted successfully", result);
        verify(orderDetailService, times(1)).deleteOrderDetail(orderDetailId);
    }
}
