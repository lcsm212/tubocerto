package com.tubocerto.tubo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tubocerto.tubo.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
