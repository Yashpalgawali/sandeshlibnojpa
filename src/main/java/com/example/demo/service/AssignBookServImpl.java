package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.AssignedBooks;
import com.example.demo.repository.AssignBookRepo;

@Service("assignbookserv")
public class AssignBookServImpl implements AssignBookService {

	@Autowired
	AssignBookRepo assignbookerpo;
	
	@Override
	public int assignBook(AssignedBooks books) {
		// TODO Auto-generated method stub
		return assignbookerpo.assignBook(books);
	}

	@Override
	public List<AssignedBooks> getAllAssignedBooks() {
		// TODO Auto-generated method stub
		return assignbookerpo.getAllAssignedBooks();
	}

}
