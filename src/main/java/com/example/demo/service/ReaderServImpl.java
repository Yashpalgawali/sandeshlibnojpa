package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.Readers;
import com.example.demo.repository.ReaderRepository;

@Service("readerserv")
public class ReaderServImpl implements ReaderService {

	@Autowired
	ReaderRepository readerrepo;
	
	@Override
	public int saveReader(Readers reader) {
		// TODO Auto-generated method stub
		return readerrepo.saveReader(reader);
	}

	@Override
	public List<Readers> getAllReaders() {
		// TODO Auto-generated method stub
		return readerrepo.getAllReaders();
	}

	@Override
	public List<Readers> getReaderById(Long id) {
		// TODO Auto-generated method stub
		try {
			return readerrepo.getReaderById(id);
		}
		catch(Exception e)
		{
			return null;
		}
		
	}

	@Override
	public int updateReader(Readers reader) {
		// TODO Auto-generated method stub
		return readerrepo.updateReader(reader);
	}

}
