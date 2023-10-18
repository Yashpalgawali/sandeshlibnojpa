package com.example.demo.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class BookAssignHistory {
	
	private Long hist_id;
	
	private Long book_id;
	
	private Long reader_id;
	
	private String operation;
	
	private String operation_date;
	
	private String operation_time;
	
	private String assign_date;
	
	private String assign_time;
	
	private Readers readers;
	
	private Books books;
}