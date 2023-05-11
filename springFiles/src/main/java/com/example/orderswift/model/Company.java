package com.example.orderswift.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Company")
@Table(name = "companies")
@Data
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "company_id",
            updatable = false
    )
    private Integer id;
    @Column(name = "company_name")
    private String name;
    @Column(name = "company_contact")
    private String contact;
    @Column(name = "company_industry")
    private String industry;
    @Column(name = "order_description")
    private String description;
    @Column(name = "company_subscription_date")
    private LocalDateTime subscriptionDate;
}
