package com.tubocerto.tubo.repositories;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tubocerto.tubo.services.CodigoBarra;

@Repository
public interface MyRepository extends JpaRepository <CodigoBarra,Long> {
	@Query("your custom query here")
	Entity findByFeature(String a);
	}
