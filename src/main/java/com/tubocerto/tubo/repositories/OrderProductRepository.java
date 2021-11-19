package com.tubocerto.tubo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tubocerto.tubo.entities.OrderProduct;



public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

}
