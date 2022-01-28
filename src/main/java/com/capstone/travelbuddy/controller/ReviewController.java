package com.capstone.travelbuddy.controller;

import com.capstone.travelbuddy.model.Review;
import com.capstone.travelbuddy.model.Shop;
import com.capstone.travelbuddy.model.User;
import com.capstone.travelbuddy.repository.ReviewRepository;
import com.capstone.travelbuddy.repository.ShopRepository;
import com.capstone.travelbuddy.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@Controller
public class ReviewController {
	private ReviewRepository reviewDao;
	private ShopRepository shopDao;
	private UserRepository userDao;

	public ReviewController(ReviewRepository reviewDao, UserRepository userDao, ShopRepository shopDao) {
		this.reviewDao = reviewDao;
		this.shopDao = shopDao;
		this.userDao = userDao;
	}

	@GetMapping("/create/review/shop/{id}")
	public String getCreateReview(Model model, @PathVariable int id) {

		Review review = new Review();
		model.addAttribute("review", review);
		model.addAttribute("shop", shopDao.getById(id));

		return "review";
	}

	@PostMapping("create/review/shop/{id}")
	public String saveReview(@RequestParam int rating, @RequestParam String description, @PathVariable int id) {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Shop shop = shopDao.getById(id);

		Review review = new Review();
		review.setUser(user);
		review.setShop(shop);
		review.setRating(rating);
		review.setDescription(description);
		review.setCreated(LocalDate.now());
		System.out.println(review);
		reviewDao.save(review);

		return "redirect:/shop/" + id;
	}

	@GetMapping("/review/edit/{id}")
	public String editPost(Model model, @PathVariable int id) {
		Review review = reviewDao.getById(id);
		model.addAttribute("review", review);
		model.addAttribute("titleLabel", "Edit Description: ");
		model.addAttribute("bodyLabel", "Edit Rating: ");

		return "form";
	}

	@PostMapping("review/edit/{id}")
	public String saveEditPost(@RequestParam int rating, @RequestParam String description, @PathVariable int id) {
		Review review = reviewDao.getById(id);
		review.setRating(rating);
		review.setDescription(description);
		reviewDao.save(review);
		System.out.println(review);
		return "redirect:/profile";
	}

	@PostMapping("/review/delete/{id}")
	public String deletePostById(@PathVariable int id) {
		reviewDao.deleteById(id);

		return "redirect:/profile";
	}
}
