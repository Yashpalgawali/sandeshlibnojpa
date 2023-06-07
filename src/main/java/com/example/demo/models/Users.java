package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

	
	private Long   user_id;
	
	private String user_name;
	
	private String user_email;
	
	private String user_contact;
	
	private String user_type;
	
	
	
}