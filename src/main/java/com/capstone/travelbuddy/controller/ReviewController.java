package com.capstone.travelbuddy.controller;

import com.capstone.travelbuddy.model.Review;
import com.capstone.travelbuddy.repository.ReviewRepository;
import com.capstone.travelbuddy.repository.ShopRepository;
import com.capstone.travelbuddy.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {
	private ReviewRepository reviewDao;
	private ShopRepository shopDao;
	private UserRepository userDao;

	public ReviewController(ReviewRepository reviewDao, UserRepository userDao, ShopRepository shopDao){
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
	public String saveReview(@RequestParam int rating, @RequestParam String description, @PathVariable int id){

		Review review = new Review();
		review.setRating(rating);
		review.setDescription(description);
		System.out.println(review);

		return "home";
	}

	//	@PostMapping("create/review/shop/{id}")
//	public String saveReview(@ModelAttribute Review review){
//		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		Shop shop = shopDao.getById(id);
//
//		List<Review> userReviews = user.getReviews();
//		userReviews.add(review);
//
//		review.setUser(user);
//		review.setShop(shop);
//		review.setCreated(LocalDate.now());
//		reviewDao.save(review);
//		System.out.println(review.getId());
//
//		user.setReviews(userReviews);
//
//		System.out.println(review);
//		return "home";
//	}
}
