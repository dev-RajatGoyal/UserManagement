package com.root.controller;

import java.util.NoSuchElementException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.root.model.User;
import com.root.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/userlogin")
	public String userLogin() {
		
		return "UserLogin";
	}

	@PostMapping("/userdashboard")
	public String loginSuccess(@RequestParam("username") String userName, @RequestParam("password") String userPassword,
			Model model, HttpServletRequest request) {

			HttpSession session = request.getSession(true);
			
			if(session!=null)
			{
				try {

					Optional<User> us = userService.userLogin(userName, userPassword);
					session.setAttribute("user", us);
					model.addAttribute("name", us.get().getUsername());

					return "UserDashboard";
				}

				catch (NoSuchElementException e) {

					System.out.println("failed");
					return "LoginFailed";
				}
			}
			
			else
			{
				return "LoginFailed";
			}
		}
		

	@GetMapping("/register")
	public String userRegister() {
		return "Registration";
	}

	@PostMapping("/user")
	public String userRegisterSuccess(User user, Model model) {
		
		System.out.println(user);
		model.addAttribute("user", user);
		
		try {
				
			userService.saveUser(user);
			
			return "registerSuccess";
		}
		catch(Exception e)
		{
			return "";
		}
	}

	@GetMapping("/viewdetails")
	public String viewDetails(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();

		if(session!=null)
		{
			Optional<User> user = (Optional<User>) session.getAttribute("user");
			model.addAttribute("userid", user.get().getId());
			model.addAttribute("username", user.get().getUsername());
			model.addAttribute("email", user.get().getEmail());
			model.addAttribute("phone", user.get().getPhoneNo());
			model.addAttribute("gender", user.get().getGender());

			return "FindUser";
		}
		else
		{
			return "Error";
		}
		
	}

	@GetMapping("/updatedetails")
	public String update(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		Optional<User> user = (Optional<User>) session.getAttribute("user");
		
		model.addAttribute("email", user.get().getEmail());
		model.addAttribute("phone", user.get().getPhoneNo());
		model.addAttribute("password", user.get().getPassword());
		
		return "updateDetails";
	}

	@PostMapping("/updated")
	public String updateSuccess(HttpServletRequest request,User user, Model model)
	{
		HttpSession session = request.getSession();
		
		
		if(session!=null)
		{
			Optional<User> old = (Optional<User>) session.getAttribute("user");
			User u = userService.getUserById(old.get().getUsername());
			
			u.setEmail(user.getEmail());
			u.setPhoneNo(user.getPhoneNo());
			u.setPassword(user.getPassword());
			
			model.addAttribute("username", u.getUsername());
			model.addAttribute("email", user.getEmail());
			model.addAttribute("phone", user.getPhoneNo());
			model.addAttribute("password",user.getPassword());
			
			userService.saveUser(u);
			
			return "UpdateSuccess";
		}
		else
		{
			return "Error";
		}
	}
	
//	@GetMapping("/Home")
//	public String userLogout(HttpServletRequest request)
//	{
//		HttpSession session = request.getSession();
//		
//		session.invalidate();
//		
//		return "Home";
//	}
	
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession(false);
		session.invalidate(); 
		modelAndView.setViewName("redirect:/");
		return modelAndView;
	}

}
