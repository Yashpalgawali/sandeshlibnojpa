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
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.models.Readers;
import com.example.demo.service.BookService;
import com.example.demo.service.ReaderService;

@Controller
public class ReaderController {

	@Autowired
	ReaderService readerserv;
	
	@Autowired
	BookService bookserv;
	
	@GetMapping("/addreader")
	public String addReader(Model model)
	{
		bookserv.getAllBooks();
		return "AddReader";
	}
	
	@PostMapping("savereader")
	public String saveReader(@RequestBody Readers reader)
	{
		int res = readerserv.saveReader(reader);
		if(res> 0)
		{
			return "redirect:/viewreaders";
		}
		else {
			return "Reader not saved";
		}
	}
	
	@GetMapping("/viewreaders")
	public String getAllReaders(Model model) {
		model.addAttribute("rlist", readerserv.getAllReaders());
		return "ViewReaders";
	}
	
	@GetMapping("editreaderbyid/{id}")
	public String getReaderById(@PathVariable("id")Long id,Model model,RedirectAttributes attr) {
		List<Readers> reader = readerserv.getReaderById(id);
		if(reader.size()>0) {
			Readers read = reader.get(0);
			model.addAttribute("reader", read);
			return "EditReader";
		}
		else {
			attr.addFlashAttribute("reserr", "No reader found for given id");
			return "redirect:/viewreaders";
		}
	}
	
	@RequestMapping("/updatereader")
	public String updateReader(@ModelAttribute("Readers") Readers reader,RedirectAttributes attr)
	{
		int res = readerserv.updateReader(reader);
		if(res>0) {
			attr.addFlashAttribute("response", "Reader data Updated successfully");
			return "redirect:/viewreaders";
		}
		else {
			attr.addFlashAttribute("reserr", "Reader data not updated ");
			return "redirect:/viewreaders";
		}
	}
}
