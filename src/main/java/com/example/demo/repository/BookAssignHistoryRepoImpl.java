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

import com.example.demo.models.BookAssignHistory;
import com.example.demo.models.Books;
import com.example.demo.models.Readers;

@Repository("bookassignhistrepo")
public class BookAssignHistoryRepoImpl implements BookAssignHistoryRepo {

	@Autowired
	JdbcTemplate temp;
	
	@Override
	public int saveBookasignHistory(BookAssignHistory bookassinghist) {

		return temp.update("insert into book_assign_history values('0',?,?,?,?)", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setLong(1, bookassinghist.getBook_id());
				ps.setLong(2, bookassinghist.getReader_id());
				ps.setString(3, bookassinghist.getAssign_date());
				ps.setString(4, bookassinghist.getAssign_time());
			}
		});
	}

	@Override
	public List<BookAssignHistory> getBookAssignHistoryByReadersId(Long reder_id) {
		// TODO Auto-generated method stub
		return temp.query("SELECT * FROM book_assign_history "
						+ " JOIN tbl_books ON tbl_books.book_id=book_assign_history.book_id "
						+ " JOIN tbl_readers ON tbl_readers.reader_id=book_assign_history.reader_id", new RowMapper<BookAssignHistory>() {

			@Override
			public BookAssignHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				BookAssignHistory bhist = new BookAssignHistory();
				bhist.setBook_id(rs.getLong(1));
				bhist.setReader_id(rs.getLong(2));
				bhist.setAssign_date(rs.getString(3));
				bhist.setAssign_time(rs.getString(4));
				
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
				
				Readers reader = new Readers();
				reader.setReader_id(rs.getLong(16));
				reader.setReader_name(rs.getString(17));
				reader.setReader_email(rs.getString(18));
				reader.setReader_address(rs.getNString(19));
				reader.setReader_contact(rs.getString(20));
				
				bhist.setBooks(book);
				bhist.setReaders(reader);
				return bhist;
			}
		});
	}

}
