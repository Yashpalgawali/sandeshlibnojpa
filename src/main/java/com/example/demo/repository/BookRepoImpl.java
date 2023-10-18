package com.example.demo.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.models.AssignedBooks;
import com.example.demo.models.Books;

@Repository("bookrepo")
public class BookRepoImpl implements BookRepository {

	@Autowired
	JdbcTemplate temp;
	
	@Override
	public int saveBook(Books book) {
		// TODO Auto-generated method stub
		
		return temp.update("INSERT INTO tbl_books values('0',?,?,?,?,?,?,?,?,?)", new PreparedStatementSetter() {
			
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
				ps.setString(8, book.getAdd_date());
				ps.setString(9, book.getAdd_time());
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
				book.setAdd_date(rs.getString(9));
				book.setAdd_time(rs.getString(10));
				return book;
			}
		});
	}

	@Override
	public List<Books> getBookByBookId(Long id) {

	
		return temp.query("SELECT * FROM tbl_books WHERE book_id="+id, new RowMapper<Books>() {

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
				book.setAdd_date(rs.getString(9));
				book.setAdd_time(rs.getString(10));
				return book;
			}
		});
	}

	@Override
	public int updateBook(Books book) {
		// TODO Auto-generated method stub
		return temp.update("update tbl_books set book_name=?,book_author=?,description=?,price=?,publisher=?,published_date=?,qty=?,add_date=?,add_time=? WHERE book_id=?", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, book.getBook_name());
				ps.setString(2, book.getBook_author());
				ps.setString(3, book.getDescription());
				ps.setFloat( 4, book.getPrice());
				ps.setString(5, book.getPublisher());
				ps.setString(6, book.getPublished_date());
				ps.setInt(7, book.getQty());
				ps.setString(8, book.getAdd_date());
				ps.setString(9, book.getAdd_time());
				ps.setLong( 10, book.getBook_id());
			}
		});
	}

	@Override
	public int getBooksQuantity(int bid) {
		
		return temp.queryForObject("SELECT qty FROM tbl_books WHERE book_id="+bid, Integer.class);
	}

	

	@Override
	public int updateBookQuanity(Long bookid, int qty) {
		// TODO Auto-generated method stub
		return temp.update("UPDATE tbl_books set qty=? WHERE book_id=?", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				
				ps.setInt(1, qty);
				ps.setLong(2, bookid);
			}
		});
	}

}
