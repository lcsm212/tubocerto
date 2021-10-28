package com.tubocerto.tubo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tubocerto.tubo.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
