package com.example.orderswift.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "TransactionUser")
@Table(name = "transactions_users")
@Data
@NoArgsConstructor
public class TransactionUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "transaction_user_id",
            updatable = false
    )
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;
}
