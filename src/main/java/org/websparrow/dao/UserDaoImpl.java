package org.websparrow.dao;

import javax.sql.DataSource;


import org.springframework.jdbc.core.JdbcTemplate;
import org.websparrow.model.User;

public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;

	public UserDaoImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}

	@Override
	public boolean registerUser(User user) {
		
		String sql = "INSERT INTO users(username,password) VALUES(?,?)";

		try {
			
			int counter = jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword() });
			
			if(counter>0)
				return true;
				else
					return false;
			

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String loginUser(User user) {
		
		String sql = "SELECT username FROM users WHERE username=? AND password=?";
		
		try {

			String username = jdbcTemplate.queryForObject(sql, new Object[] {
					user.getUsername(), user.getPassword() }, String.class);

			return username;
			
		} catch (Exception e) {
			return null;
		}
	}
}
