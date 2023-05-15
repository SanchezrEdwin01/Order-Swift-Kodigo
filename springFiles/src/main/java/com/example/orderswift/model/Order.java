package com.example.orderswift.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;


@Entity(name = "Order") @Table(name = "orders") @Data @AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "total_amount")
    private Double totalAmount;

    public Order(int i, String s, String s1, double v, String aNew) {
    }

    public Order() {

    }

    public Order(int i, Date date, String string, double v) {
    }

    public Integer getOrderId() {
        return orderId;
    }
}