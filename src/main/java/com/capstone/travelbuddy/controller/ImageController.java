package com.capstone.travelbuddy.controller;

import com.capstone.travelbuddy.model.Image;
import com.capstone.travelbuddy.repository.ImageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Objects;

@Controller
public class ImageController {

	private ImageRepository imageDao;

	public ImageController(ImageRepository imageDao){
		this.imageDao = imageDao;
	}

	@GetMapping("/upload")
	public String getUploadView(){
		return "upload";
	}

	@PostMapping("/upload")
	public String uploadImage(@RequestParam("image")MultipartFile multipartFile, RedirectAttributes redirectAttributes) throws IOException {

		String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
		Image image = new Image();
		image.setName(fileName);
		image.setContent(multipartFile.getBytes());

		imageDao.save(image);

		redirectAttributes.addFlashAttribute("message", "Upload successful!");

		return "upload";
	}
}
