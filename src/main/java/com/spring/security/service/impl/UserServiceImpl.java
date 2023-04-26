package com.spring.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.security.entities.Users;
import com.spring.security.service.IuserService;

@Service
public class UserServiceImpl implements IuserService {
	
	List<Users> user=new ArrayList<>();

	@Override
	public List<Users> getUsers() {
		return this.user;
	}
	
	public UserServiceImpl() {
		user.add(new Users("Twinkle","Twinkle@2001", "kaushaltwinki@gmail.com"));
		user.add(new Users("Annu", "Annu@2001", "annu@gmail.com"));
		
	}


	@Override
	public Users getUserByUsername(String username) {
		return this.user.stream().filter((users)->users.getUsername().equals(username)).findAny().orElse(null);
	}

	@Override
	public Users adduser(Users user) {
		this.user.add(user);
		return user;
	}

}
