package com.example.demo.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.AssignedBooks;
import com.example.demo.models.BookAssignHistory;
import com.example.demo.repository.AssignBookRepo;
import com.example.demo.repository.BookAssignHistoryRepo;

@Service("assignbookserv")
public class AssignBookServImpl implements AssignBookService {

	LocalDateTime local = LocalDateTime.now();
	DateTimeFormatter dformat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	DateTimeFormatter tformat = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	@Autowired
	AssignBookRepo assignbookerpo;
	
	@Autowired
	BookAssignHistoryRepo bookassignhistrepo;
	
	@Override
	public int assignBook(AssignedBooks books) {
		int res = assignbookerpo.assignBook(books);
		
		if(res>0) {
			BookAssignHistory bhist = new BookAssignHistory();
			bhist.setAssign_date(dformat.format(local));
			bhist.setAssign_time(tformat.format(local));
			bhist.setBook_id(Long.parseLong(books.getBook_id()));
			bhist.setReader_id(books.getReader_id());
			
			bookassignhistrepo.saveBookasignHistory(bhist);
		}
		return  res;
	}

	@Override
	public List<AssignedBooks> getAllAssignedBooks() {
		// TODO Auto-generated method stub
		return assignbookerpo.getAllAssignedBooks();
	}

}
