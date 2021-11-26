package com.tubocerto.tubo.repositories;

import java.util.Collection;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tubocerto.tubo.entities.User;
import com.tubocerto.tubo.services.CodigoBarra;

@Repository
public interface MyRepository extends JpaRepository <CodigoBarra,Long> {
	@Query("SELECT * FROM User WHERE .status = 1")
	Collection<User> findAllActiveUsers();
	Entity findByFeature(String a);
	}
