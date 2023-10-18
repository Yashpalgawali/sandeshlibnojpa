package com.example.demo.controller;

import java.util.List;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.models.AssignedBooks;
import com.example.demo.models.Books;
import com.example.demo.models.Readers;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.AssignBookService;
import com.example.demo.service.BookService;
import com.example.demo.service.ReaderService;

@Controller
public class AssignBookController {

	@Autowired
	ReaderService readerserv;
	
	@Autowired
	BookService bookserv;
	
	@Autowired
	AssignBookService assignbookserv;
	
	@GetMapping("assignbook")
	public String assignBook(Model model) {
		
		model.addAttribute("book", bookserv.getAllBooks());
		model.addAttribute("reader", readerserv.getAllReaders());
		return "AssignBook";
	}
	
	@PostMapping("assignbook")
	public String assignBook(@ModelAttribute("AssignedBook")AssignedBooks assignbook,RedirectAttributes attr) {
		
		String book_ids = assignbook.getBook_id();
		String newbids[] = book_ids.split(",");
		int res = 0;
		for(String bookid : newbids)
		{
			assignbook.setBook_id(bookid);
			res = assignbookserv.assignBook(assignbook);
		}
		
		if(res>0) {
			attr.addFlashAttribute("response", "Book Assigned Successfully");
			return "redirect:/viewreaders";
		}
		else {
			attr.addFlashAttribute("reserr", "Book is not Assigned ");
			return "redirect:/viewreaders";
		}
	}
	
	@GetMapping("/retrievebooksbyid/{id}")
	public String retrieveAssignedBooks(@PathVariable("id")Long id,Model model,RedirectAttributes attr)
	{
		List<AssignedBooks> asbooks = assignbookserv.getAllAssignedBooksByReaderId(id);
		if(asbooks.size()>0)
		{
			String assigned_books = "";
			for(int i=0;i<asbooks.size();i++) {
				if(i==0) {
					assigned_books = asbooks.get(i).getBooks().getBook_name();
				}
				else {
					assigned_books = assigned_books+","+asbooks.get(i).getBooks().getBook_name();
				}
			}
			model.addAttribute("assigned_books", assigned_books);
			model.addAttribute("blist", asbooks);
			return "RetrieveAssignedBooks";
		}
		else {
			model.addAttribute("reserr", "No Book is assigned ");
			return "redirect:/viewreaders";
		}
	}
	
	@PostMapping("/retrievebooks")@ResponseBody
	public String retrieveBooksByReadersId(@ModelAttribute("Readers") Readers reader)
	{
		
		return ""+reader.getAssigned_book_ids();
	}
	
}

