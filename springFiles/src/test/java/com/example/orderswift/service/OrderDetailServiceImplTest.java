package com.example.orderswift.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.orderswift.exception.ResourceNotFoundException;
import com.example.orderswift.model.OrderDetail;
import com.example.orderswift.repository.OrderDetailRepository;
import com.example.orderswift.service.orderdetail.OrderDetailServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderDetailServiceImplTest {

    @Mock
    private OrderDetailRepository orderDetailRepository;

    @InjectMocks
    private OrderDetailServiceImpl orderDetailService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveOrderDetail() {
        OrderDetail orderDetail = new OrderDetail();

        String result = orderDetailService.saveOrderDetail(orderDetail);

        assertEquals("New order detail has been added", result);
        verify(orderDetailRepository, times(1)).save(orderDetail);
    }

    @Test
    void testGetAllOrdersDetail() {
        List<OrderDetail> orderDetails = Arrays.asList(new OrderDetail(), new OrderDetail());
        when(orderDetailRepository.findAll()).thenReturn(orderDetails);

        List<OrderDetail> result = orderDetailService.getAllOrdersDetail();

        assertEquals(orderDetails, result);
        verify(orderDetailRepository, times(1)).findAll();
    }

    @Test
    void testGetOrderDetailByIdOrder() {
        Integer orderDetailId = 1;
        OrderDetail orderDetail = new OrderDetail();
        when(orderDetailRepository.findById(orderDetailId)).thenReturn(Optional.of(orderDetail));

        OrderDetail result = orderDetailService.getOrderDetailByIdOrder(orderDetailId);

        assertEquals(orderDetail, result);
        verify(orderDetailRepository, times(1)).findById(orderDetailId);
    }

    @Test
    void testGetOrderDetailByIdOrder_OrderDetailNotFound() {
        Integer orderDetailId = 1;
        when(orderDetailRepository.findById(orderDetailId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> orderDetailService.getOrderDetailByIdOrder(orderDetailId));
        verify(orderDetailRepository, times(1)).findById(orderDetailId);
    }

    @Test
    void testUpdateOrderDetail() {
        Integer orderDetailId = 1;
        OrderDetail existingOrderDetail = new OrderDetail();
        OrderDetail newOrderDetail = new OrderDetail();
        when(orderDetailRepository.findById(orderDetailId)).thenReturn(Optional.of(existingOrderDetail));
        when(orderDetailRepository.save(existingOrderDetail)).thenReturn(existingOrderDetail);

        OrderDetail result = orderDetailService.updateOrderDetail(newOrderDetail, orderDetailId);

        assertSame(existingOrderDetail, result);
        verify(orderDetailRepository, times(1)).findById(orderDetailId);
        verify(orderDetailRepository, times(1)).save(existingOrderDetail);
        assertEquals(newOrderDetail.getQuantity(), existingOrderDetail.getQuantity());
        assertEquals(newOrderDetail.getUnitPrice(), existingOrderDetail.getUnitPrice());
        assertEquals(newOrderDetail.getOrder(), existingOrderDetail.getOrder());
        assertEquals(newOrderDetail.getProduct(), existingOrderDetail.getProduct());
    }

    @Test
    void testUpdateOrderDetail_OrderDetailNotFound() {
        Integer orderDetailId = 1;
        OrderDetail newOrderDetail = new OrderDetail();
        when(orderDetailRepository.findById(orderDetailId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> orderDetailService.updateOrderDetail(newOrderDetail, orderDetailId));
        verify(orderDetailRepository, times(1)).findById(orderDetailId);
    }

    @Test
    void testDeleteOrderDetail() {
        Integer orderDetailId = 1;

        String result = orderDetailService.deleteOrderDetail(orderDetailId);

        assertEquals("The order detail with the ID num 1 has been deleted success", result);
        verify(orderDetailRepository, times(1)).deleteById(orderDetailId);
    }

}