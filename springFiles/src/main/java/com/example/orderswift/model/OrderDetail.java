package com.example.orderswift.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity(name = "OrderDetail")
@Table(name = "ordersDetails")
@Data
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Integer orderDetailId;

    @Column(name = "quantity")
    @Positive(message = "Quantity must be greater than zero")
    private Integer quantity;

    @Column(name = "unit_price")
    @Positive(message = "Unit price must be greater than zero")
    private Double unitPrice;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}