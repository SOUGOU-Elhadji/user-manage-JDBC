package com.saraya.usermanage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.usermanage.entity.User;
import com.saraya.usermanage.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	
	@GetMapping("/users")
	public List<User> getAll(){
		return userRepository.getAll();
	}
	
	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		return userRepository.saveUser(user);
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable int id) {
		return userRepository.getById(id);
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id) {
		return userRepository.delete(id);
	}
	
	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {
		return userRepository.updateUser(user);
	}
	
	
}
