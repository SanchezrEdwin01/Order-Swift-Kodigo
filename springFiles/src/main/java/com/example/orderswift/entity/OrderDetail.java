package com.example.orderswift.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name = "OrderDetail")
@Table(name = "ordersDetails")
@Getter @Setter
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "order_detail_id",
            updatable = false
    )
    private Integer orderDetailId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(
            nullable = false
    )
    private Integer quantity;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;
}