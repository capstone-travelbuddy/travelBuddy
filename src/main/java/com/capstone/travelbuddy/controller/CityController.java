package com.capstone.travelbuddy.controller;

import com.capstone.travelbuddy.model.Shop;
import com.capstone.travelbuddy.repository.CityRepository;
import com.capstone.travelbuddy.repository.ShopRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class CityController {

	private CityRepository cityDao;
	private ShopRepository shopDao;

	public CityController(CityRepository cityDao, ShopRepository shopDao){
		this.cityDao = cityDao;
		this.shopDao = shopDao;
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
	public String getCoffeeView(Model model){
		model.addAttribute("shops", shopDao.getShopsByCityId(1));
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

	@GetMapping("/shop/{id}")
	public String getShopView(@PathVariable int id, Model model){
//		Shop shop = shopDao.findById(id);
//		model.addAttribute("shop", shop);
		System.out.println(id);
		return "shop";
	}

	@GetMapping("/create/review")
	public String getCreateReview(){
		return "leaveReview";
	}

}
