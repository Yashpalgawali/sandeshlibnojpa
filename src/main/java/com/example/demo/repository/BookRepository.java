package com.example.demo.repository;

import java.util.List;

import com.example.demo.models.Books;

public interface BookRepository {

	public int saveBook(Books book);
	
	public List<Books> getAllBooks();
	
	public List<Books> getBookByBookId(Long id);
	
	public int updateBook(Books book);
	
	public int getBooksQuantity(int book_id);
	
	public int getLastInsertedRecord();
	
	public int updateBookQuanity(Long bookid,int qty);
}
