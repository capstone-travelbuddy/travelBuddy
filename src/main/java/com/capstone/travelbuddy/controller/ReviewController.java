package com.capstone.travelbuddy.controller;

import com.capstone.travelbuddy.model.Review;
import com.capstone.travelbuddy.repository.ReviewRepository;
import com.capstone.travelbuddy.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class ReviewController {
	private ReviewRepository reviewDao;
	private UserRepository userDao;

	public ReviewController(ReviewRepository reviewDao, UserRepository userDao){
		this.reviewDao = reviewDao;
		this.userDao = userDao;
	}

	@GetMapping("/review")
	public String showReviewForm(Model model){
		model.addAttribute("review", new Review());
		return "review";
	}

	@PostMapping("/review")
	public String saveReview(@ModelAttribute Review review){
		review.setUser(userDao.getById(1));
		review.setCreated(LocalDate.now());
		reviewDao.save(review);
		return "cities";
	}
}
