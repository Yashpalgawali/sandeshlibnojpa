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

import com.example.demo.models.AssignedBooks;
import com.example.demo.models.Books;
import com.example.demo.models.Users;

@Repository("assignbookrepo")
public class AssignedBookRepoImpl implements AssignBookRepo {

	@Autowired
	JdbcTemplate temp;
	
	@Override
	public int assignBook(AssignedBooks books) {
		// TODO Auto-generated method stub
		return temp.update("INSERT INTO assigned_books VALUES('0',?,?,?,?)", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				ps.setString(1, books.getAssign_date());
				ps.setString(2, books.getAssign_time());
				ps.setString(3, books.getBook_id());
				ps.setLong(4, books.getReader_id());
			}
		});
	}

	@Override
	public List<AssignedBooks> getAllAssignedBooks() {
		// TODO Auto-generated method stub
		return temp.query("SELECT * FROM assigned_books JOIN tbl_books ON tbl_books.book_id=assigned_books.book_id "
						+ " JOIN tbl_users ON tbl_users.user_id=assigned_books.users_id", new RowMapper<AssignedBooks>() {

			@Override
			public AssignedBooks mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
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
				
				Users user = new Users();
				user.setUser_name(rs.getString(14));
				user.setUser_email(rs.getString(15));
				user.setUser_contact(rs.getString(16));
				
				books.setUsers(user);
				
				return books;
			}
		});
	}

}
