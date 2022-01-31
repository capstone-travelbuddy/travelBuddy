package com.capstone.travelbuddy.controller;

import com.capstone.travelbuddy.model.Category;
import com.capstone.travelbuddy.model.City;
import com.capstone.travelbuddy.model.Shop;
import com.capstone.travelbuddy.model.User;
import com.capstone.travelbuddy.repository.CategoryRepository;
import com.capstone.travelbuddy.repository.CityRepository;
import com.capstone.travelbuddy.repository.ShopRepository;
import com.capstone.travelbuddy.repository.UserRepository;
import com.capstone.travelbuddy.service.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
public class CityController {

	private CityRepository cityDao;
	private ShopRepository shopDao;
	private CategoryRepository categoryDao;
	private UserRepository userDao;
	private final EmailService emailService;


	public CityController(CityRepository cityDao, ShopRepository shopDao, CategoryRepository categoryDao, UserRepository userDao, EmailService emailService) {
		this.cityDao = cityDao;
		this.shopDao = shopDao;
		this.categoryDao = categoryDao;
		this.userDao = userDao;
		this.emailService = emailService;
	}
  
	@Value("${mapbox.api.key}")
	private String mapboxApiKey;

	@RequestMapping("/like/shop/{id}")
	public String addToShopLikes(@PathVariable int id, RedirectAttributes attributes){
		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Shop shop = shopDao.getById(id);
		User user = userDao.getById(currentUser.getId());

		if (user.getLikedShops().contains(shop)){
			user.getLikedShops().remove(shop);
			userDao.save(user);
			attributes.addFlashAttribute("remove", "Unliked!");
			return "redirect:/shop/" + id;
		}

		user.getLikedShops().add(shop);
		userDao.save(user);
		attributes.addFlashAttribute("add", "Liked!");

		return "redirect:/shop/" + id;
	}

	@GetMapping("/")
	public String getHomeView(){
		return "home";
	}

	@GetMapping("/destinations")
	public String getCitiesView(Model model) {
		model.addAttribute("cities", cityDao.findAll());

		return "destinations";
	}

	@GetMapping("/category/{id}")
	public String getCategoryView(@PathVariable int id, Model model) {
		model.addAttribute("city", cityDao.getById(id));
		model.addAttribute("categories", categoryDao.findAll());

		return "categories";
	}

	@GetMapping("category/{categoryType}/{id}")
	public String getCoffeeView(@PathVariable int id, @PathVariable String categoryType, Model model) {
		model.addAttribute("shops", shopDao.getShopsByCityIdAndCategoryType(id, categoryType));

		return "category";
	}

	@GetMapping("/shop/{id}")
	public String getShopView(@PathVariable int id, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)){
			User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			User user = userDao.getById(currentUser.getId());
			Shop shop = shopDao.getById(id);
			model.addAttribute("shop", shop);
			model.addAttribute("user", user);
			model.addAttribute("mapboxApiKey", mapboxApiKey);

			return "shop";
		}
		Shop shop = shopDao.getById(id);
		model.addAttribute("shop", shop);
		model.addAttribute("mapboxApiKey", mapboxApiKey);

		return "shop";
	}
	@GetMapping("/search")
	public String shopSearch(Model model){
		model.addAttribute("shop", new Shop());
		return "search";
	}

	@PostMapping("/search")
	public String showShop(@RequestParam(name="shops") String shops, Model model){
		Shop shop = new Shop();
		shop.setName(shops);
		System.out.println(shops);
		model.addAttribute("shops", shopDao.findByNameIgnoreCaseContaining(shops));
		return "search";
	}

	@GetMapping("/shop/recommend")
	public String getRecommendShop(Model model){
		model.addAttribute("cities", cityDao.findAll());
		model.addAttribute("categories", categoryDao.findAll());
		return "shop-recommend-form";
	}

	@PostMapping("/shop/recommend")
	public String saveRecommendShop(RedirectAttributes attributes, @RequestParam(name = "city") int cityId, @RequestParam(name = "category") int categoryId, @RequestParam(name = "shopName") String shopName){
		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		City city = cityDao.getById(cityId);
		Category category = categoryDao.getById(categoryId);
		System.out.println(city.getName());
		System.out.println(category.getName());
		System.out.println(shopName);

		String postBody = "Your shop recommendation has been submitted for review. \n" + "City: " +city.getName() + "\n" + "Category: " + category.getName() + "\n" + "Shop name: " + shopName;
		emailService.prepareAndSend(currentUser, "New Shop Recommendation", postBody);

		attributes.addFlashAttribute("add", "Recommendation submitted!");

		return "redirect:/profile";
	}
  
	}