package com.tubocerto.tubocerto.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tubocerto.tubocerto.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "luiz", "luiz.marzola@tubocerto.com", "975508268", "12345");
		return ResponseEntity.ok().body(u);
	}
}
