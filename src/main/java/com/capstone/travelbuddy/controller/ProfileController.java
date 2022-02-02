package com.capstone.travelbuddy.controller;

import com.capstone.travelbuddy.model.Image;
import com.capstone.travelbuddy.model.User;
import com.capstone.travelbuddy.repository.ImageRepository;
import com.capstone.travelbuddy.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Objects;

@Controller
public class ProfileController {

    private UserRepository userDao;
    private ImageRepository imageDao;

    public ProfileController(UserRepository userDao, ImageRepository imageDao){
        this.userDao = userDao;
        this.imageDao = imageDao;
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", userDao.getById(user.getId()));

        return "profile";
    }

    @GetMapping("/profile/edit")
    public String editProfile(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", userDao.getById(user.getId()));
        model.addAttribute("titleLabel", "Edit Username: ");
        model.addAttribute("bodyLabel", "Edit Email: ");

        return "edit-profile";
    }

    @PostMapping("/profile/edit")
    public String saveEditProfile(@RequestParam String username, @RequestParam String email) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.getById(currentUser.getId());
        user.setUsername(username);
        user.setEmail(email);
        userDao.save(user);
        System.out.println(user);
        return "redirect:/profile";
    }

    @GetMapping("/profile/upload")
    public String editProfilePicture(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", userDao.getById(user.getId()));

        return "users/user-photo-upload";
    }

    @PostMapping("/profile/upload")
    public String uploadImage(@RequestParam("image") MultipartFile multipartFile) throws IOException {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.getById(currentUser.getId());

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        Image image = new Image();
        image.setName(fileName);
        image.setContent(multipartFile.getBytes());

        imageDao.save(image);

        user.setUserImage(image);
        userDao.save(user);

        return "redirect:/profile";
    }

    @GetMapping("/profile/delete")
    public String deleteUser(){

        return "delete-profile";
    }

    @PostMapping("/profile/delete")
    public String deleteUserById() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        SecurityContextHolder.clearContext();
        userDao.deleteById(user.getId());

        return "home";
    }

}

