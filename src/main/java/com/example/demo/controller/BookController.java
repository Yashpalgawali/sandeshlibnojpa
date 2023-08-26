package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.models.AssignedBooks;
import com.example.demo.models.Books;
import com.example.demo.service.AssignBookService;
import com.example.demo.service.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bookserv;
	
	@Autowired
	AssignBookService assignbookserv;
	
	
	@GetMapping("/addbook")
	public String addBook()
	{
		return "AddBook";
	}
	
//	@PostMapping("/savebook")
//	public String saveBook(@RequestBody Books book)
//	//public String saveBook(@ModelAttribute("Books") Books book)
//	{
//		int res = bookserv.saveBook(book);
//		if(res>0)
//		{
//			return "redirect:/viewbooks";
//		}
//		else
//		{
//			return "redirect:/viewbooks";
//		}
//	}
	
	@PostMapping("/savebook")
	public String saveBook(@ModelAttribute("Books") Books book)
	//public String saveBook(@ModelAttribute("Books") Books book)
	{
		System.out.println("Books info is \n Book Name = "+book.getBook_name()+"\nAuthor ="+book.getBook_author()+"\nQuantity = "+book.getQty());
		return "redirect:/addbook";
//		int res = bookserv.saveBook(book);
//		if(res>0)
//		{
//			return "redirect:/viewbooks";
//		}
//		else
//		{
//			return "redirect:/viewbooks";
//		}
	}
	
	@GetMapping("/viewbooks")
	public String viewBooks(Model model)
	{
		List<Books> blist = bookserv.getAllBooks();
		blist.stream().forEach(e->System.err.println(e.getBook_name()));
		model.addAttribute("blist", blist);
		return "ViewBooks";
	}
	
	@GetMapping("editbookbyid/{id}") 
	public String getBookById(@PathVariable("id") Long id,Model model, RedirectAttributes attr)
	{
		List<Books> book = bookserv.getBookByBookId(id);
		if(book.size()>0) {
			Books boo = book.get(0);
			model.addAttribute("book", boo);
			return "EditBook";
		}
		else {
			return "redirect:/viewbooks";
		}
	}
	
	@PostMapping("updatebook")
	public String updateBook(@ModelAttribute("Books")Books book,RedirectAttributes attr) {
		int res  = bookserv.updateBook(book);
		if(res>0) {
			attr.addFlashAttribute("response", "Book is updated successfully");
			return "redirect:/viewbooks";
		}
		else {
			attr.addFlashAttribute("reserr", "Book is not updated ");
			return "redirect:/viewbooks";
		}
	}
	
//	@GetMapping("/viewbooks")@ResponseBody
//	public List<Books> viewBooks(Model model)
//	{
//		List<Books> blist = bookserv.getAllBooks();
//		model.addAttribute("blist", blist);
//		return blist;
//	}
	
	@PostMapping("/issuebook")
	@ResponseBody
	public String issueBook(@RequestBody AssignedBooks books)
	{
		int res = assignbookserv.assignBook(books);
		if(res>0)
			{return "SUCCESS";}
		else
		{
			return "FAILED";
		}
	}
	@GetMapping("/getassignedbooks")
	@ResponseBody
	public List<AssignedBooks> getAllAssignedBooks()
	{
		return assignbookserv.getAllAssignedBooks();
	}
	
}	
