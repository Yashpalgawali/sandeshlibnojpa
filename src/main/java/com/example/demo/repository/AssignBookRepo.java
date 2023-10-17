package com.example.demo.repository;

import java.util.List;

import com.example.demo.models.AssignedBooks;

public interface AssignBookRepo {

	public int assignBook(AssignedBooks books);
	public List<AssignedBooks> getAllAssignedBooks();
}