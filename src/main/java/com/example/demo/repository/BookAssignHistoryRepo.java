package com.example.demo.repository;

import java.util.List;

import com.example.demo.models.BookAssignHistory;
import com.example.demo.models.Books;

public interface BookAssignHistoryRepo {

	public int saveBookasignHistory(BookAssignHistory bookassinghist);
	
	public List<BookAssignHistory> getBookAssignHistoryByReadersId(Long reder_id);
	
	
}
