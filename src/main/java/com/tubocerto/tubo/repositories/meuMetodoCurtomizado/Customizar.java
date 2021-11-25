package com.tubocerto.tubo.repositories.meuMetodoCurtomizado;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tubocerto.tubo.entities.User;
import com.tubocerto.tubo.repositories.UserRepository;
import com.tubocerto.tubo.services.exceptions.ResourceNotFoundException;

@Repository
public class Customizar {

	@Autowired
	private UserRepository repository;
	
	@Query(value="InnoDB")
	public void update(Long id, User obj) {
		try {
		User entity = repository.findById(id).orElse(null);
		updateData(entity, obj);
		return;
		} catch (EntityNotFoundException e) {
		throw new ResourceNotFoundException(id);
		}
	}
		
		private void updateData(User entity, User obj) {
			entity.setName(obj.getName());
			entity.setEmail(obj.getEmail());
			entity.setPhone(obj.getPhone());
		}
}
