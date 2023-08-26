package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Books;
import com.example.demo.repository.BookRepository;

@Service("bookservice")
public class BookservImpl implements BookService {

	@Autowired
	BookRepository bookrepo;
	
	@Override
	public int saveBook(Books book) {
		// TODO Auto-generated method stub
		return bookrepo.saveBook(book);
	}

	@Override
	public List<Books> getAllBooks() {
		// TODO Auto-generated method stub
		return bookrepo.getAllBooks();
	}

	@Override
	public List<Books> getBookByBookId(Long id) {
		// TODO Auto-generated method stub
		try {
			return bookrepo.getBookByBookId(id);
		}
		catch(Exception e) {
			return null;
		}
	}

	@Override
	public int updateBook(Books book) {
		// TODO Auto-generated method stub
		return bookrepo.updateBook(book);
	}

}
