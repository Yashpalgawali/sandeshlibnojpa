package com.example.demo.service;

import java.util.List;

import com.example.demo.models.Books;

public interface BookService {

	public int saveBook(Books book);
	
	public List<Books> getAllBooks();
	
	public Books getBookByBookId(Long id);
	
}
