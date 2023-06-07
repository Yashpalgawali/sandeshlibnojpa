package com.example.demo.models;

import lombok.Data;

@Data
public class AssignedBooks {

	private Long assigned_id;
	
	private String 	assign_date;
	
	private String 	assign_time;
	
	private Long book_id;
	
	private Long users_id;
	
	private Books books;
	
	private Users users;
}
