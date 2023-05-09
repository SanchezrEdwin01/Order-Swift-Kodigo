package com.example.orderswift.repository;

import com.example.orderswift.model.Order;
import com.example.orderswift.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}
