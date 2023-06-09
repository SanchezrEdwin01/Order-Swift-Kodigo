package com.example.orderswift.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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
    private Integer id;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(
            name = "order_id",
            nullable = false
    )
    private Order order;

    @Column(
            name = "transaction_date",
            updatable = false
    )
    @CreationTimestamp
    private LocalDateTime transactionDate;

    private BigDecimal amount;

    @Column(
            name = "payment_method",
            nullable = false
    )
    private String paymentMethod;

    public Transaction(int i, String s) {

    }

    @OneToMany(mappedBy = "transaction")
    private List<TransactionUser> transactionUsers;
}