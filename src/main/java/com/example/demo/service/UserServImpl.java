package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Users;
import com.example.demo.repository.UserRepository;

@Service("userserv")
public class UserServImpl implements UserService {

	@Autowired
	UserRepository userrepo;
	
	
	@Override
	public int saveUser(Users user) {
		// TODO Auto-generated method stub
		return userrepo.saveUser(user);
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return userrepo.getAllUsers();
	}

}
