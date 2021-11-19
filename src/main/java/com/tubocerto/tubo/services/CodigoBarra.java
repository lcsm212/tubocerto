package com.tubocerto.tubo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tubocerto.tubo.entities.User;
import com.tubocerto.tubo.repositories.UserRepository;
import com.tubocerto.tubo.services.exceptions.ResourceNotFoundException;

@Component
public class CodigoBarra {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}		
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
}
