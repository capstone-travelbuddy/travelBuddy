package com.capstone.travelbuddy.controller;

import com.capstone.travelbuddy.model.User;
import com.capstone.travelbuddy.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	private UserRepository userDao;

	public LoginController(UserRepository userDao){
		this.userDao = userDao;
	}

	@GetMapping("/login")
	public String showSignupForm() {
		return "users/login";
	}




	}
