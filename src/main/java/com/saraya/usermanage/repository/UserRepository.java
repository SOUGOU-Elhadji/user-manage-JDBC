package com.saraya.usermanage.repository;

import java.util.List;

import com.saraya.usermanage.entity.User;

public interface UserRepository {
	public User saveUser(User user);
	public User updateUser(User user);
	public User getById(int id);
	public String delete(int id);
	public List<User> getAll();
}
