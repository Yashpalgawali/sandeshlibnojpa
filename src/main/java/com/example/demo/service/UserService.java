package com.example.demo.service;

import java.util.List;

import com.example.demo.models.Users;

public interface UserService {

	public int saveUser(Users user);
	
	public List<Users> getAllUsers();
	
}
