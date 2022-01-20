package com.capstone.travelbuddy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CityController {

	@GetMapping("/destinations")
	public String getCitiesView(){
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

}
