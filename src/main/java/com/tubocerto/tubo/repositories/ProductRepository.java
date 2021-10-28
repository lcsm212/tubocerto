package com.tubocerto.tubo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tubocerto.tubo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
