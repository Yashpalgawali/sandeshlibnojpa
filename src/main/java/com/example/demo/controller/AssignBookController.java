package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.models.AssignedBooks;
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
		
		int res = assignbookserv.assignBook(assignbook);
		if(res>0) {
			attr.addFlashAttribute("response", "Book Assigned Successfully");
			return "redirect:/viewreaders";
		}
		else {
			attr.addFlashAttribute("reserr", "Book is not Assigned ");
			return "redirect:/viewreaders";
		}
	}
}

