package com.tubocerto.tubo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tubocerto.tubo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
