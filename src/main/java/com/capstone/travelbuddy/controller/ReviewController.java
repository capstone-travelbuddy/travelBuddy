package com.capstone.travelbuddy.controller;

import com.capstone.travelbuddy.model.Review;
import com.capstone.travelbuddy.model.Shop;
import com.capstone.travelbuddy.model.User;
import com.capstone.travelbuddy.repository.ReviewRepository;
import com.capstone.travelbuddy.repository.ShopRepository;
import com.capstone.travelbuddy.repository.UserRepository;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
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

	private void createCurrentUser(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			User user = userDao.getById(currentUser.getId());
			model.addAttribute("user", user);
		}
	}

	@GetMapping("/create/review/shop/{id}")
	public String createReview(Model model, @PathVariable int id) {
		createCurrentUser(model);

		Review review = new Review();
		model.addAttribute("review", review);
		model.addAttribute("shop", shopDao.getById(id));

		return "review";
	}

	@PostMapping("create/review/shop/{id}")
	public String saveReview(@RequestParam int rating, @RequestParam String description, @PathVariable int id) {

		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userDao.getById(currentUser.getId());
		Shop shop = shopDao.getById(id);

		if (shop.getCity().getId() == user.getCity().getId()) {
			Review review = new Review();
			review.setUser(user);
			review.setShop(shop);
			review.setRating(rating);
			review.setDescription(description);
			review.setCreated(LocalDate.now());
			review.setUserType(1);
			System.out.println(review);
			reviewDao.save(review);
			return "redirect:/shop/" + id;
		}

		Review review = new Review();
		review.setUser(user);
		review.setShop(shop);
		review.setRating(rating);
		review.setDescription(description);
		review.setCreated(LocalDate.now());
		review.setUserType(2);
		System.out.println(review);
		reviewDao.save(review);
		return "redirect:/shop/" + id;
	}

	@GetMapping("/review/edit/{id}")
	public String editReview(Model model, @PathVariable int id) {
		createCurrentUser(model);

		Review review = reviewDao.getById(id);
		model.addAttribute("review", review);
		model.addAttribute("titleLabel", "Edit Description: ");
		model.addAttribute("bodyLabel", "Edit Rating: ");

		return "edit-review";
	}

	@PostMapping("review/edit/{id}")
	public String saveEditReview(@RequestParam int rating, @RequestParam String description, @PathVariable int id) {
		Review review = reviewDao.getById(id);
		review.setRating(rating);
		review.setDescription(description);
		reviewDao.save(review);
		System.out.println(review);
		return "redirect:/profile";
	}

	@PostMapping("/review/delete/{id}")
	public String deleteReviewById(@PathVariable int id) {
		reviewDao.deleteById(id);

		return "redirect:/profile";
	}
}
