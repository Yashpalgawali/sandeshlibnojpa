package com.example.demo.repository;

import java.util.List;

import com.example.demo.models.Users;

public interface UserRepository {

	public int saveUser(Users user);
	
	public List<Users> getAllUsers();
	
}
