package com.example.demo.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.AssignedBooks;
import com.example.demo.models.BookAssignHistory;
import com.example.demo.models.Books;
import com.example.demo.repository.AssignBookRepo;
import com.example.demo.repository.BookAssignHistoryRepo;
import com.example.demo.repository.BookRepository;

@Service("assignbookserv")
public class AssignBookServImpl implements AssignBookService {

	LocalDateTime local ;
	DateTimeFormatter dformat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	DateTimeFormatter tformat = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	@Autowired
	AssignBookRepo assignbookerpo;
	
	@Autowired 
	BookRepository bookrepo;
	
	@Autowired
	BookAssignHistoryRepo bookassignhistrepo;
	
	@Override
	public int assignBook(AssignedBooks books) {
		local = LocalDateTime.now();
		books.setAssign_date(dformat.format(local));
		books.setAssign_time(tformat.format(local));
		int res = assignbookerpo.assignBook(books);
		
		if(res>0) {
			
			List<AssignedBooks> asbooks = assignbookerpo.getLastAssignedBook();
			for(int i=0;i<asbooks.size();i++) {
				
				Books book = asbooks.get(i).getBooks();
				int qty = book.getQty();
				qty = qty-1;
				bookrepo.updateBookQuanity(book.getBook_id(), qty);
			}
						
			BookAssignHistory bhist = new BookAssignHistory();
			bhist.setOperation("assigned");
			bhist.setOperation_date(dformat.format(local));
			bhist.setOperation_time(tformat.format(local));
			
			bhist.setBook_id(Long.parseLong(books.getBook_id()));
			bhist.setReader_id(books.getReader_id());
			
			bookassignhistrepo.saveBookasignHistory(bhist);
		}
		return  res;
	}

	@Override
	public List<AssignedBooks> getAllAssignedBooks() {
		return assignbookerpo.getAllAssignedBooks();
	}

	@Override
	public List<AssignedBooks> getAllAssignedBooksByReaderId(Long reader_id) {
		List<AssignedBooks> blist = assignbookerpo.getAllAssignedBooksByReaderId(reader_id);
		return blist;
	}

}
