package com.example.demo.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Readers;

@Repository("readerrepo")
public class ReadersRepoImpl implements ReaderRepository {

	@Autowired
	JdbcTemplate temp;
	
	@Override
	public int saveReader(Readers reader) {
		// TODO Auto-generated method stub
		return temp.update("INSERT INTO tbl_readers VALUES('0',?,?,?,?,?)", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, reader.getReader_name());
				ps.setString(2, reader.getReader_email());
				ps.setString(3, reader.getReader_address());
				ps.setString(4, reader.getReader_contact());
				ps.setLong(5, reader.getBook_id());
			}
		});
	}

	@Override
	public List<Readers> getAllReaders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Readers getReaderById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateReader(Readers reader) {
		// TODO Auto-generated method stub
		return 0;
	}

}
