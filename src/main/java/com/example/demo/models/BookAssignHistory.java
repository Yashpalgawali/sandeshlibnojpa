package com.example.demo.models;

import java.util.List;

import lombok.Data;

@Data
public class BookAssignHistory {
	
	private Long assign_hist_id;
	
	private Long book_id;
	
	private Long reader_id;
	
	private String assign_date;
	
	private String assign_time;
	
	private Readers readers;
	
	private Books books;
	
}