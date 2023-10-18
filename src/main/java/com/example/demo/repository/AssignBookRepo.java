package com.example.demo.repository;

import java.util.List;

import com.example.demo.models.AssignedBooks;

public interface AssignBookRepo {

	public int assignBook(AssignedBooks books);
	public List<AssignedBooks> getAllAssignedBooks();
	public List<AssignedBooks> getAllAssignedBooksByReaderId(Long id);
	public List<AssignedBooks> getLastAssignedBook();
}