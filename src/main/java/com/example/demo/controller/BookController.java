package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.models.Books;
import com.example.demo.service.BookService;

@Controller
public class BookController {

	@GetMapping("/addbook")
	public String addBook()
	{
		return "AddBook";
	}
	
	@Autowired
	BookService bookserv;
	
	
	@PostMapping("/savebook")
	public String saveBook(@RequestBody Books book)
	//public String saveBook(@ModelAttribute("Books") Books book)
	{
		int res = bookserv.saveBook(book);
		if(res>0)
		{
			return "redirect:/viewbooks";
		}
		else
		{
			return "redirect:/viewbooks";
		}
	}
	
	@GetMapping("/viewbooks")@ResponseBody
	public List<Books> viewBooks(Model model)
	{
		List<Books> blist = bookserv.getAllBooks();
		model.addAttribute("blist", blist);
		return blist;
	}
	
	
}
