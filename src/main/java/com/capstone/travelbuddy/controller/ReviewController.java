package com.capstone.travelbuddy.controller;

import com.capstone.travelbuddy.repository.ReviewRepository;

public class ReviewController {
	private ReviewRepository reviewDao;

	public ReviewController(ReviewRepository reviewDao){
		this.reviewDao = reviewDao;
	}
}
