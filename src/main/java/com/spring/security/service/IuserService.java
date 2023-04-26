package com.spring.security.service;

import java.util.List;
import java.util.stream.Stream;

import com.spring.security.entities.Users;

public interface IuserService {

	public List<Users> getUsers();
	
	public Users getUserByUsername(String username);
	
	public Users adduser(Users user);
}
