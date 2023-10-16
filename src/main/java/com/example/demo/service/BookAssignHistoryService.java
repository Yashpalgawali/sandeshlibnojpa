package com.example.demo.service;

import java.util.List;

import com.example.demo.models.BookAssignHistory;

public interface BookAssignHistoryService {

	public int saveBookasignHistory(BookAssignHistory bookassinghist);
	
	public List<BookAssignHistory> getBookAssignHistoryByReadersId(Long reader_id);
	
}