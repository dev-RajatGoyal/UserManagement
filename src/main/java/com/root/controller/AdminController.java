package com.root.controller;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.root.model.Admin;
import com.root.model.User;
import com.root.service.AdminService;
import com.root.service.UserService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/adminlogin")
	public String adminLogin() {
		return "AdminLogin";
	}

	@PostMapping("/admindashboard")
	public String adminloginSuccess(@RequestParam("username") String userName,
			@RequestParam("password") String Password, Model model) {
		
		try {

			Optional<Admin> admin = adminService.adminlogin(userName, Password);
			
			model.addAttribute("name", admin.get().getUsername());
			return "AdminDashboard";
		}

		catch (NoSuchElementException e) {

			return "LoginFailed";
		}
	}
	
	@GetMapping("/allusers")
	public String viewAllUsers(Model model)
	{
		ArrayList<User> users = (ArrayList<User>) adminService.viewAllUsers();
		model.addAttribute("listOfUsers",users);
		
		return "findall";
	}
	
//	@PostMapping("/deleteuser")
//	public String deleteUser(@RequestParam("userId") String id)
//	{
//		System.out.println(id);
//		return "delete";
//	}
//	
	@PostMapping("/userdeleted")
	public String userdeleted(@RequestParam("userName") String username, Model model)
	{
		//int userid = Integer.parseInt(userId);
//		ArrayList<User> users = (ArrayList<User>) adminService.viewAllUsers();
//		//String message = "User deleted Successfully";
//		for(User us : users)
//		{
//			if(us.getId() == userId)
//			{				
				User user = userService.getUserById(username);
				
				adminService.deleteUser(user.getId());
				String message1 = "User "+username+" deleted Successfully";
				model.addAttribute("message1",message1);
				return "AdminDashboard";
//			}
//		}
//		
		//return "Error";
		
	}
}
