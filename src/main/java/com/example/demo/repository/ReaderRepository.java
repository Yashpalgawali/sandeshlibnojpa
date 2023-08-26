package com.example.demo.repository;

import java.util.List;

import com.example.demo.models.Readers;

public interface ReaderRepository {

	public int saveReader(Readers reader);
	
	public List<Readers> getAllReaders();
	
	public List<Readers> getReaderById(Long id);
	
	public int updateReader(Readers reader);
}
