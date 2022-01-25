package com.capstone.travelbuddy.controller;

import com.capstone.travelbuddy.model.User;
import com.capstone.travelbuddy.repository.CityRepository;
import com.capstone.travelbuddy.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	private UserRepository userDao;
	private PasswordEncoder passwordEncoder;
	private CityRepository cityDao;

	public UserController(UserRepository userDao, PasswordEncoder passwordEncoder, CityRepository cityDao) {
		this.userDao = userDao;
		this.passwordEncoder = passwordEncoder;
		this.cityDao = cityDao;
	}

	@GetMapping("/sign-up")
	public String showSignupForm(Model model){
		model.addAttribute("user", new User());
		model.addAttribute("cities", cityDao.findAll());
		return "users/sign-up";
	}

	@PostMapping("/sign-up")
	public String saveUser(@ModelAttribute User user){
		String hash = passwordEncoder.encode(user.getPassword());
		user.setPassword(hash);
		userDao.save(user);
		return "redirect:/login";
	}

//	@GetMapping(path = "/profile/edit/{id}")
//	public String editProfile(@PathVariable long id, Model model){
//		Profile editProfile = userDao.getById(id);
//
//		model.addAttribute("profileToEdit", editProfile);
//
//		return "profile/edit";
//	}
//
//	@PostMapping("/profile/edit")
//	public String saveEditProfile(@RequestParam(name="profileName") String profileName, @RequestParam(name="profileEmail") String profileEmail, long id){
//
//		Profile profileToEdit = userDao.getById(id);
//		profileToEdit.setName(profileName);
//		profileToEdit.setEmail(profileEmail);
//
//		userDao.save(profileToEdit);
//
//		return "redirect:/profile";
//	}
}


 
