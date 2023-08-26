package com.example.demo.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Books;
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
 
				ps.setString(1, reader.getReader_name());
				ps.setString(2, reader.getReader_email());
				ps.setString(3, reader.getReader_address());
				ps.setString(4, reader.getReader_contact());
				
			}
		});
	}

	@Override
	public List<Readers> getAllReaders() {
		// TODO Auto-generated method stub
		return temp.query("select * from tbl_readers ", new RowMapper<Readers>() {

			@Override
			public Readers mapRow(ResultSet rs, int rowNum) throws SQLException {

				Readers reader = new Readers();
				
				reader.setReader_id(rs.getLong(1));
				reader.setReader_name(rs.getString(2));
				reader.setReader_email(rs.getString(3));
				reader.setReader_address(rs.getString(4));
				reader.setReader_contact(rs.getString(5));
				
				return reader;
			}
			
		});
	}

	@Override
	public List<Readers> getReaderById(Long id) {
		// TODO Auto-generated method stub
		return temp.query("SELECT * FROM tbl_readers  WHERE tbl_readers.reader_id="+id, new RowMapper<Readers>() {

			@Override
			public Readers mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Readers reader = new Readers();
				reader.setReader_id(rs.getLong(1));
				reader.setReader_name(rs.getString(2));
				reader.setReader_email(rs.getString(3));
				reader.setReader_address(rs.getString(4));
				reader.setReader_contact(rs.getString(5));
				
				return reader;
			}
			
		});
	}

	@Override
	public int updateReader(Readers reader) {
		
		return temp.update("UPDATE tbl_readers SET reader_name=?,reader_email=?,reader_address=?,reader_contact=? WHERE reader_id=?", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
 
				ps.setString(1, reader.getReader_name());
				ps.setString(2, reader.getReader_email());
				ps.setString(3, reader.getReader_address());
				ps.setString(4, reader.getReader_contact());
				ps.setLong(5, reader.getReader_id());
			}
		});
	}

}
