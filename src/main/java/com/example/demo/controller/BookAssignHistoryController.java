package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.BookAssignHistory;
import com.example.demo.repository.BookAssignHistoryRepo;

@RestController
public class BookAssignHistoryController {

	
	@Autowired
	BookAssignHistoryRepo histrepo;
	
	@GetMapping("/history/{id}")
	public List<BookAssignHistory> getBookAssignHistoryByreaderId(@PathVariable("id") Long id)
	{
		return histrepo.getBookAssignHistoryByReadersId(id);
	}
}
