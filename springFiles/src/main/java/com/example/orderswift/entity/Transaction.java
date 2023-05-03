package com.example.orderswift.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "Transaction")
@Table(name = "transactions")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "transaction_id",
            updatable = false
    )
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    private User user;

    @ManyToOne
    @JoinColumn(
            name = "order_id",
            nullable = false
    )
    private Order order;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    private BigDecimal amount;

    @Column(
            name = "payment_method",
            nullable = false
    )
    private String paymentMethod;
}