package com.spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.entities.Users;
import com.spring.security.service.IuserService;

@RestController
public class UserController {
	
	@Autowired
	IuserService userService;
	
	@GetMapping("/welcome")
	public String home() {
		return "WELCOME";
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/users")
	public List<Users> getAllUsers(){
		return this.userService.getUsers();
		
	}
	@GetMapping("/users/{username}")
	public Users getByUsername(@PathVariable("username") String username) {
		return userService.getUserByUsername(username);
		
	}
	
	@PostMapping("/users/new")
	public Users addUser(@RequestBody Users user) {
		return userService.adduser(user);
		
	}

}
