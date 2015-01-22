package com.crudweb.Dao;

import java.util.List;

import com.crudweb.model.User;

public interface UserDao {
	public List<User> list();
	public void add(User user);
	public void delete(int userId);
	public void edit(User user);
	public User findUser(int userId);
	
}
