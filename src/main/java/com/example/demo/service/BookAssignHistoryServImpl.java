package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.BookAssignHistory;
import com.example.demo.repository.BookAssignHistoryRepo;

@Service("bookassignhistserv")
public class BookAssignHistoryServImpl implements BookAssignHistoryService {

	@Autowired
	BookAssignHistoryRepo bookassignhistrepo;
	
	@Override
	public int saveBookasignHistory(BookAssignHistory bookassinghist) {
		// TODO Auto-generated method stub
		return bookassignhistrepo.saveBookasignHistory(bookassinghist);
	}

	@Override
	public List<BookAssignHistory> getBookAssignHistoryByReadersId(Long reader_id) {
		
		List<BookAssignHistory> bhist= bookassignhistrepo.getBookAssignHistoryByReadersId(reader_id);
		int res =bhist.size();
		if(res>0)
		{
			return bhist;
		}
		else { 
			return null;
		}
	}

}
