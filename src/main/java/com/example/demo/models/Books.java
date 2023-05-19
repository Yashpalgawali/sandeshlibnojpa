package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Books {

	
	private Long book_id;
	
	private String book_name;
	
	private String book_author;
	
	private String description;
	
	private float price;
	
	private String publisher;
	
	private String published_date;
	
	private int qty;
	
}
