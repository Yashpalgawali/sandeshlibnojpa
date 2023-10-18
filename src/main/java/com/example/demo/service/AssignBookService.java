package com.example.demo.service;

import java.util.List;

import com.example.demo.models.AssignedBooks;

public interface AssignBookService {
	
	public int assignBook(AssignedBooks books);
	
	public List<AssignedBooks> getAllAssignedBooks();
	
	public List<AssignedBooks> getAllAssignedBooksByReaderId(Long reader_id);
	
	
}
