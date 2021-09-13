package com.root.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.model.Admin;
import com.root.model.User;
import com.root.repository.AdminDao;
import com.root.repository.UserDao;

@Service
public class AdminService {
	
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	UserDao userDao;
	
	public Optional<Admin> adminlogin(String username, String password)
	{
		return adminDao.login(username, password);
	}
	
	public List<User> viewAllUsers()
	{
		 return userDao.findAll();
	}
	
	public void deleteUser(int userId)
	{
		userDao.deleteById(userId);
	}
}
