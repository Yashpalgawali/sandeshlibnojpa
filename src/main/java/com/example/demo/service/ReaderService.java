package com.example.demo.service;

import java.util.List;

import com.example.demo.models.Readers;

public interface ReaderService {
public int saveReader(Readers reader);
	
	public List<Readers> getAllReaders();
	
	public Readers getReaderById(Long id);
	
	public int updateReader(Readers reader);
}
