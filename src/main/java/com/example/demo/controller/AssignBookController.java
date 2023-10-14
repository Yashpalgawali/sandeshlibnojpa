package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.models.AssignedBooks;
import com.example.demo.service.BookService;
import com.example.demo.service.ReaderService;

@Controller
public class AssignBookController {

	@Autowired
	ReaderService readerserv;
	
	@Autowired
	BookService bookserv;
	
	
	@GetMapping("assignbook")
	public String assignBook(Model model) {
		
		model.addAttribute("book", bookserv.getAllBooks());
		model.addAttribute("reader", readerserv.getAllReaders());
		return "AssignBook";
	}
	
	@PostMapping("assignbook")@ResponseBody
	public String assignBook(@ModelAttribute("AssignedBook")AssignedBooks assignbook) {
		
		return ""+assignbook.toString();
	}
	
	
}

