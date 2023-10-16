package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.demo.models.BookAssignHistory;
import com.example.demo.repository.BookAssignHistoryRepo;

@Controller
public class BookAssignHistoryController {

	
	@Autowired
	BookAssignHistoryRepo histrepo;
	
	@GetMapping("/history/{id}")
	public String getBookAssignHistoryByreaderId(@PathVariable("id") Long id,Model model,RedirectAttributes attr) {
		List<BookAssignHistory> bhist = histrepo.getBookAssignHistoryByReadersId(id);
		if(bhist.size()>0) {
			model.addAttribute("hist", bhist);
			return "ViewBookAssignHistory";
		}
		else {
			attr.addFlashAttribute("reserr", "No Book is assigned to the ID "+id);
			return "redirect:/viewreaders";
		}
	}
}
