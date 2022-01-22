package com.capstone.travelbuddy.controller;

import com.capstone.travelbuddy.repository.CategoryRepository;
import com.capstone.travelbuddy.repository.CityRepository;
import com.capstone.travelbuddy.repository.ShopRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CityController {

	private CityRepository cityDao;
	private ShopRepository shopDao;
	private CategoryRepository categoryDao;

	public CityController(CityRepository cityDao, ShopRepository shopDao, CategoryRepository categoryDao) {
		this.cityDao = cityDao;
		this.shopDao = shopDao;
		this.categoryDao = categoryDao;
	}

	@GetMapping("/destinations")
	public String getCitiesView(Model model) {
		model.addAttribute("cities", cityDao.findAll());

		return "cities";
	}

	@GetMapping("/category/{id}")
	public String getCategoryView(@PathVariable int id, Model model) {
		model.addAttribute("city", cityDao.getById(id));
		model.addAttribute("categories", categoryDao.findAll());

		return "sa-categories";
	}

	@GetMapping("category/{categoryType}/{id}")
	public String getCoffeeView(@PathVariable int id, @PathVariable String categoryType, Model model) {
		model.addAttribute("shops", shopDao.getShopsByCityIdAndCategoryType(id, categoryType));

		return "category";
	}

	@GetMapping("category/coffee/shop/{id}")
	public String getShopView(@PathVariable int id, Model model) {
//		Shop shop = shopDao.findById(id);
//		model.addAttribute("shop", shop);
		System.out.println(id);
		return "shop";
	}

	@GetMapping("/create/review")
	public String getCreateReview() {
		return "leaveReview";
	}

}
