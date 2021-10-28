package com.tubocerto.tubo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tubocerto.tubo.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
