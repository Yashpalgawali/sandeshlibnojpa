package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SandeshlibrarynojpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SandeshlibrarynojpaApplication.class, args);
	
		// create a list and filter all even numbers
//		List<Integer> inlist = Arrays.asList(1,20,47,54,5655,87,78,90);
//		
//		List<Integer> nlist = inlist.stream().filter(e->e%2==0).collect(Collectors.toList());
//	
//		System.err.println(nlist); 
	}

}
