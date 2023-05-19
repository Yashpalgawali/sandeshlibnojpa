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

@Repository("bookrepo")
public class BookRepoImpl implements BookRepository {

	@Autowired
	JdbcTemplate temp;
	
	@Override
	public int saveBook(Books book) {
		// TODO Auto-generated method stub
		return temp.update("INSERT INTO tbl_books values('0',?,?,?,?,?,?,?)", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, book.getBook_name());
				ps.setString(2, book.getBook_author());
				ps.setString(3, book.getDescription());
				ps.setFloat(4, book.getPrice());
				ps.setString(5, book.getPublisher());
				ps.setString(6, book.getPublished_date());
				ps.setInt(7, book.getQty());
			}
		});
	}

	@Override
	public List<Books> getAllBooks() {
		// TODO Auto-generated method stub
		return temp.query("SELECT * from tbl_books", new RowMapper<Books>() {

			@Override
			public Books mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Books book = new Books();
				
				book.setBook_id(rs.getLong(1));
				book.setBook_name(rs.getString(2));
				book.setBook_author(rs.getString(3));
				book.setDescription(rs.getString(4));
				book.setPrice(rs.getFloat(5));
				book.setPublisher(rs.getString(6));
				book.setPublished_date(rs.getString(7));
				book.setQty(rs.getInt(8));
				
				return book;
			}
		});
	}

	@Override
	public Books getBookByBookId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
