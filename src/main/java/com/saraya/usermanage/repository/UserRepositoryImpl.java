package com.saraya.usermanage.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.saraya.usermanage.entity.User;


@Repository
public class UserRepositoryImpl implements UserRepository {

	private static final String INSERT_USER_QUERY = "INSERT INTO USER(id,firstName,lastName,email,password) values(?,?,?,?,?)";
    private static final String UPDATE_USER_BY_ID_QUERY = "UPDATE USER SET firstName=?, lastName=?, email=?, password=?  WHERE ID=?";
    private static final String GET_USER_BY_ID_QUERY = "SELECT * FROM USER WHERE ID=?";
    private static final String DELETE_USER_BY_ID = "DELETE FROM USER WHERE ID=?";
    private static final String GET_USERS_QUERY = "SELECT * FROM USER";
    @Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(INSERT_USER_QUERY, user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
        return user;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(UPDATE_USER_BY_ID_QUERY, user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
        return user;
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		 return jdbcTemplate.queryForObject(GET_USER_BY_ID_QUERY, (rs, rowNum) -> {

	            return new User(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"), rs.getString("password"));
	        },id);
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(DELETE_USER_BY_ID, id);
        return "User got deleted with id " + id;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(GET_USERS_QUERY, (rs, rowNum) -> {
            return new User(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"), rs.getString("password"));
        });
	}

}
