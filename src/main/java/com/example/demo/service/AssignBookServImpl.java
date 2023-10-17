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

	LocalDateTime local = LocalDateTime.now();
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
		books.setAssign_date(dformat.format(local));
		books.setAssign_time(tformat.format(local));
		int res = assignbookerpo.assignBook(books);
		
		if(res>0) {
			
			int lid = assignbookerpo.getLastInsertedRecord();
			System.err.println("laset reocrd inserted ID = "+lid);
			String lasid =""+lid;
			Long li = Long.valueOf(lasid);
			List<Books> bks = bookrepo.getBookByBookId(li);
			System.out.println("Books assigned successfully\n result size "+bks.size());
			for(int i=0;i<bks.size();i++)
			{
				System.err.println(bks.get(i).toString());
				Books book = bks.get(i);
				int qty = book.getQty();
				qty = qty-1;
				bookrepo.updateBookQuanity(book.getBook_id(), qty);
			}
						
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
