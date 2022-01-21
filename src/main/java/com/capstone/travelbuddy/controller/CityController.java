package com.capstone.travelbuddy.controller;

import com.capstone.travelbuddy.repository.CityRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CityController {

	private CityRepository cityDao;

	public CityController(CityRepository cityDao){
		this.cityDao = cityDao;
	}

	@GetMapping("/destinations")
	public String getCitiesView(Model model){
		model.addAttribute("cities", cityDao.findAll());
		return "cities";
	}

	@GetMapping("/category")
	public String getCategoryView(){
		return "sa-categories";
	}

	@GetMapping("/coffee")
	public String getCoffeeView(){
		return "coffee";
	}

	@GetMapping("/brews")
	public String getBrewsView(){
		return "brews";
	}

	@GetMapping("/eats")
	public String getEatsView(){
		return "eats";
	}

	@GetMapping("/shop")
	public String getShopView(){
		return "shop";
	}

	@GetMapping("/create/review")
	public String getCreateReview(){
		return "leaveReview";
	}

}
