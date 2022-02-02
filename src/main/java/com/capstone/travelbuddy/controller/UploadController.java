package com.capstone.travelbuddy.controller;

import com.capstone.travelbuddy.model.Image;
import com.capstone.travelbuddy.model.Shop;
import com.capstone.travelbuddy.model.User;
import com.capstone.travelbuddy.repository.ImageRepository;
import com.capstone.travelbuddy.repository.ShopRepository;
import com.capstone.travelbuddy.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Objects;

@Controller
public class UploadController {

	private ImageRepository imageDao;
	private ShopRepository shopDao;
	private UserRepository userDao;

	public UploadController(ImageRepository imageDao, ShopRepository shopDao, UserRepository userDao){
		this.imageDao = imageDao;
		this.shopDao = shopDao;
		this.userDao = userDao;
	}

	@GetMapping("/shop/{id}/upload")
	public String getUploadView(@PathVariable int id, Model model){
		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userDao.getById(currentUser.getId());
		Shop shop = shopDao.getById(id);

		model.addAttribute("user", user);
		model.addAttribute("shop", shop);

		return "photo-upload";
	}

	@PostMapping("/shop/{id}/upload")
	public String uploadImage(@RequestParam("image") MultipartFile multipartFile, Model model, @PathVariable int id) throws IOException {

		Shop shop = shopDao.getById(id);
		model.addAttribute("shop", shop);

		String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
		Image image = new Image();
		image.setName(fileName);
		image.setContent(multipartFile.getBytes());
		image.setShop(shop);

		imageDao.save(image);

		model.addAttribute("message", "Upload successful!");

		return "redirect:/shop/" + id;
	}
}
