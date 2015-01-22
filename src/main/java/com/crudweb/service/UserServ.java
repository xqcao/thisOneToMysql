package com.crudweb.service;

import java.util.List;

import com.crudweb.model.User;

public interface UserServ {
	public List<User> list();
	public void add(User user);
	public void delete(int userId);
	public void edit(User user);
	public User findUser(int userId);
}
