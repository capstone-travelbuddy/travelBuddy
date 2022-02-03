package com.capstone.travelbuddy.controller;

import com.capstone.travelbuddy.model.Image;
import com.capstone.travelbuddy.repository.ImageRepository;
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
public class ImageController {

	private ImageRepository imageDao;

	public ImageController(ImageRepository imageDao) {
		this.imageDao = imageDao;
	}

	@GetMapping("/upload")
	public String getUploadView() {
		return "upload";
	}

	@PostMapping("/upload")
	public String uploadImage(@RequestParam("image") MultipartFile multipartFile, Model model) throws IOException {

		String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
		Image image = new Image();
		image.setName(fileName);
		image.setContent(multipartFile.getBytes());

		imageDao.save(image);

		model.addAttribute("message", "Upload successful!");

		return "upload";
	}

	@GetMapping(value = "images/{id}")
	public String helloWorld(@PathVariable int id, Model model) {
		Image image = imageDao.getById(id);
		model.addAttribute("image", image);
		return "images";
	}
}
