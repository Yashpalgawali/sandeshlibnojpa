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

import com.example.demo.models.Users;

@Repository("userrepo")
public class UserRepoImpl implements UserRepository {

	@Autowired
	JdbcTemplate temp;
	
	
	@Override
	public int saveUser(Users user) {
		// TODO Auto-generated method stub
		return temp.update("INSERT INTO tbl_users VALUES('0',?,?,?,?)", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, user.getUser_name());
				ps.setString(2, user.getUser_email());
				ps.setString(3, user.getUser_contact());
				ps.setString(4, user.getUser_type());
			}
		});
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return temp.query("SELECT * FROM tbl_users", new RowMapper<Users>() {

			@Override
			public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				Users user = new Users();
				user.setUser_id(rs.getLong(1));
				user.setUser_name(rs.getString(2));
				user.setUser_email(rs.getString(3));
				user.setUser_contact(rs.getString(4));
				user.setUser_type(rs.getString(5));
				
				return user;
			}
			
		});
	}

}
