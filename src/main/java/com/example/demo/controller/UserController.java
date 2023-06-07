package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.models.Users;
import com.example.demo.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userserv;
	
	@PostMapping("/saveuser")
	public String saveUser(@RequestBody Users user)
	{
		int res = userserv.saveUser(user);
		if(res>0)
		{
			return "redirect:/getallusers";
		}
		else{return "redirect:/getallusers";}
	}
	
	@GetMapping("/getallusers")@ResponseBody
	public List<Users> getAllUsers()
	{
		return userserv.getAllUsers();
	}
}
