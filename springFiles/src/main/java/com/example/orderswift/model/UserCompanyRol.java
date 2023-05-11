package com.example.orderswift.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "UserCompanyRol")
@Table(name = "user_company_roles")
@Data @NoArgsConstructor
public class UserCompanyRol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "user_comp_id",
            updatable = false
    )
    private Integer id;
    private String role;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
