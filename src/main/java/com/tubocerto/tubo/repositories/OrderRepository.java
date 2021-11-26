package com.tubocerto.tubo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tubocerto.tubo.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	
	@Query(nativeQuery = true, value = "select * from tb_order")
	List<Order>getIds();
}
