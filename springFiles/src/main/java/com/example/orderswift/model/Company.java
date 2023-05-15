package com.example.orderswift.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "Company")
@Table(name = "companies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "company_id",
            updatable = false
    )
    private Integer id;
    @NotBlank(message = "Name must not be null or blank")
    private String name;
    @Column(name = "company_contact")
    @NotBlank(message = "Contact must not be null or blank")
    private String contact;
    @Column(name = "company_industry")
    @NotBlank(message = "Industry must not be null or blank")
    private String industry;
    @Column(name = "order_description")
    private String description;
    @Column(
            name = "company_subscription_date",
            updatable = false
    )
    @CreationTimestamp
    private LocalDateTime subscriptionDate;

    public Company(int i, String s, String s1, String s2, String s3, LocalDate now) {
    }
}
