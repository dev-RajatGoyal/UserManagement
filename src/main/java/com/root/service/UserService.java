package com.root.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.model.User;
import com.root.repository.UserDao;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public Optional<User> userLogin(String username, String password)
	{
		return userDao.login(username, password);	
	}
	
	public void saveUser(User user)
	{
		userDao.save(user);
	}
	
	public User getUserById(String username)
	{
		return userDao.findByUsername(username);
	}
	
	public User updateUser(User user)
	{
		User updatedUser = userDao.save(user);
		return updatedUser;
	}
}
