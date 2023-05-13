package com.example.orderswift.repository;

import com.example.orderswift.model.UserCompanyRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCompanyRoleRepository extends JpaRepository<UserCompanyRol, Integer> {
}
