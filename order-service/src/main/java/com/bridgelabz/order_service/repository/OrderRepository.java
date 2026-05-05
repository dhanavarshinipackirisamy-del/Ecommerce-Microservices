package com.bridgelabz.order_service.repository;

import com.bridgelabz.order_service.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}