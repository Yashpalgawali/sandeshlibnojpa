package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.models.Readers;
import com.example.demo.service.ReaderService;

@Controller
public class ReaderController {

	@Autowired
	ReaderService readerserv;
	
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
	
	@GetMapping("/viewreaders")@ResponseBody
	public List<Readers> getAllReaders()
	{
		return readerserv.getAllReaders();
	}
	
	@GetMapping("getreaderbyid/{id}")
	public String getReaderById(@PathVariable("id")Long id)
	{
		Readers reader = readerserv.getReaderById(id);
		if(reader!=null)
		{
			return "EditReader";
		}
		else
		{
			return "redirect:/viewreaders";
		}
	}
}
