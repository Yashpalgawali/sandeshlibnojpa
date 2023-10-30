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
import com.example.demo.models.Readers;
import com.example.demo.models.Users;

@Repository("assignbookrepo")
public class AssignedBookRepoImpl implements AssignBookRepo {

	@Autowired
	JdbcTemplate temp;
	
	@Override
	public int assignBook(AssignedBooks books) {

		return temp.update("INSERT INTO assigned_books VALUES('0',?,?,?,?)", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				
				ps.setString(1, books.getAssign_date());
				ps.setString(2, books.getAssign_time());
				ps.setString(3, books.getBook_id());
				ps.setLong(4, books.getReader_id());
			}
		});
	}

	@Override
	public List<AssignedBooks> getAllAssignedBooks() {
	
		return temp.query("SELECT * FROM assigned_books JOIN tbl_books ON tbl_books.book_id=assigned_books.book_id "
						+ " JOIN tbl_readers ON tbl_readers.reader_id=assigned_books.reader_id", new RowMapper<AssignedBooks>() {

			@Override
			public AssignedBooks mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				AssignedBooks books = new AssignedBooks();
				books.setAssigned_id(rs.getLong(1));
				books.setAssign_date(rs.getString(2));
				books.setAssign_time(rs.getString(3));
				
				Books book = new Books();
				book.setBook_id(rs.getLong(6));
				book.setBook_name(rs.getString(7));
				book.setBook_author(rs.getString(8));
				book.setDescription(rs.getString(9));
				
				books.setBooks(book);
				
				Readers reader = new Readers();
				reader.setReader_id(rs.getLong(16));
				reader.setReader_name(rs.getString(17));
				reader.setReader_email(rs.getString(18));
				reader.setReader_address(rs.getString(19));
//				Users user = new Users();
//				user.setUser_name(rs.getString(14));
//				user.setUser_email(rs.getString(15));
//				user.setUser_contact(rs.getString(16));
//				
				books.setReader(reader);
				
				return books;
			}
		});
	}
	
	@Override
	public List<AssignedBooks> getLastAssignedBook() {
		
		return temp.query("SELECT * FROM assigned_books JOIN tbl_books ON tbl_books.book_id=assigned_books.book_id ORDER BY assigned_id DESC LIMIT 1", new RowMapper<AssignedBooks>() {

			@Override
			public AssignedBooks mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				AssignedBooks  abooks = new AssignedBooks();
				abooks.setAssigned_id(rs.getLong(1));
				abooks.setAssign_date(rs.getString(2));
				abooks.setAssign_time(rs.getString(3));
				abooks.setBook_id(rs.getString(4));
				abooks.setReader_id(rs.getLong(5));
				
				Books book = new Books();
				book.setBook_id(rs.getLong(6));
				book.setBook_name(rs.getString(7));
				book.setBook_author(rs.getString(8));
				book.setDescription(rs.getString(9));
				book.setPrice(rs.getFloat(10));
				book.setPublisher(rs.getString(11));
				book.setPublished_date(rs.getString(12));
				book.setQty(rs.getInt(13));
				book.setAdd_date(rs.getString(14));
				book.setAdd_time(rs.getString(15));
				
				abooks.setBooks(book);
				
				return abooks;
			}
		});
	}

	@Override
	public List<AssignedBooks> getAllAssignedBooksByReaderId(Long id) {
		return temp.query("SELECT * FROM assigned_books JOIN tbl_books ON tbl_books.book_id=assigned_books.book_id "
				+ " JOIN tbl_readers ON tbl_readers.reader_id=assigned_books.reader_id WHERE assigned_books.reader_id="+id, new RowMapper<AssignedBooks>() {

	@Override
	public AssignedBooks mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		AssignedBooks books = new AssignedBooks();
		books.setAssigned_id(rs.getLong(1));
		books.setAssign_date(rs.getString(2));
		books.setAssign_time(rs.getString(3));
		
		Books book = new Books();
		book.setBook_id(rs.getLong(6));
		book.setBook_name(rs.getString(7));
		book.setBook_author(rs.getString(8));
		book.setDescription(rs.getString(9));
		
		books.setBooks(book);
		
		Readers reader = new Readers();
		reader.setReader_id(rs.getLong(16));
		reader.setReader_name(rs.getString(17));
		reader.setReader_email(rs.getString(18));
		reader.setReader_address(rs.getString(19));
		reader.setReader_contact(rs.getString(20));
		
		books.setReader(reader);
		
		return books;
	}
});
	}
}