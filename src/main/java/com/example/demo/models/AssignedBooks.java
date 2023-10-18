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
	
	private String book_id;
	
	private Long reader_id;
	
	private Books books;
	
	private Users users;
	
	private Readers reader;
}
