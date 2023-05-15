package com.example.orderswift.repository;

import com.example.orderswift.model.UserCompanyRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCompanyRoleRepository extends JpaRepository<UserCompanyRol, Integer> {
    Optional<UserCompanyRol>findByEmail(String email);
}
