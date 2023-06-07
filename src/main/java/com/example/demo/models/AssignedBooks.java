package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignedBooks {

	private Long assigned_id;
	
	private String 	assign_date;
	
	private String 	assign_time;
	
	private Long book_id;
	
	private Long users_id;
	
	private Books books;
	
	private Users users;
}
