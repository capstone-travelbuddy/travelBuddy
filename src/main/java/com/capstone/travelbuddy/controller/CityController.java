package com.capstone.travelbuddy.controller;

import com.capstone.travelbuddy.model.City;
import com.capstone.travelbuddy.model.Shop;
import com.capstone.travelbuddy.repository.CategoryRepository;
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
	private CategoryRepository categoryDao;

	public CityController(CityRepository cityDao, ShopRepository shopDao, CategoryRepository categoryDao){
		this.cityDao = cityDao;
		this.shopDao = shopDao;
		this.categoryDao = categoryDao;
	}

	@GetMapping("/destinations")
	public String getCitiesView(Model model){
		model.addAttribute("cities", cityDao.findAll());
		return "cities";
	}

	@GetMapping("/category/{id}")
	public String getCategoryView(@PathVariable int id, Model model){
		model.addAttribute("city", cityDao.getById(id));
		model.addAttribute("categories", categoryDao.findAll());

		return "sa-categories";
	}

	@GetMapping("category/coffee/{id}")
	public String getCoffeeView(@PathVariable int id, Model model){
		model.addAttribute("shops", shopDao.getShopsByCityId(id));
		return "coffee";
	}

	@GetMapping("category/brews/{id}")
	public String getBrewsView(@PathVariable int id){
		return "brews";
	}

	@GetMapping("category/eats/{id}")
	public String getEatsView(@PathVariable int id){
		return "eats";
	}

	@GetMapping("category/coffee/shop/{id}")
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
