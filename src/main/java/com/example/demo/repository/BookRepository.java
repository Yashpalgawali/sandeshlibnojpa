package com.example.demo.repository;

import java.util.List;

import com.example.demo.models.Books;

public interface BookRepository {

	public int saveBook(Books book);
	
	public List<Books> getAllBooks();
	
	public Books getBookByBookId(Long id);
	
	
	
}
