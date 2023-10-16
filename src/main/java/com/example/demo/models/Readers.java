package com.example.demo.models;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Readers {

	private Long reader_id;
	
	private String reader_name;
	
	private String reader_email;
	
	private String reader_address;
	
	private String reader_contact;

	private Long book_id; 
	
	private List<Books> books;
	
	private Books book;
}