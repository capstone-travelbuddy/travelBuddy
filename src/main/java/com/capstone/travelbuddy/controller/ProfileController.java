package com.capstone.travelbuddy.controller;

import com.capstone.travelbuddy.model.Review;
import com.capstone.travelbuddy.model.User;
import com.capstone.travelbuddy.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {

    private UserRepository userDao;

    public ProfileController(UserRepository userDao){
        this.userDao = userDao;
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", userDao.getById(user.getId()));

        return "profile";
    }

    @GetMapping("/profile/edit/{id}")
    public String editProfile(Model model, @PathVariable int id) {
        User user = userDao.getById(id);
        model.addAttribute("user", user);
        model.addAttribute("titleLabel", "Edit Username: ");
        model.addAttribute("bodyLabel", "Edit Email: ");

        return "edit-profile";
    }

    @PostMapping("/profile/edit/{id}")
    public String saveEditProfile(@RequestParam String username, @RequestParam String email, @PathVariable int id) {
        User user = userDao.getById(id);
        user.setUsername(username);
        user.setEmail(email);
        userDao.save(user);
        System.out.println(user);
        return "redirect:/profile";
    }

    @GetMapping("/profile/delete/{id}")
    public String deleteProfile(Model model, @PathVariable int id){
        User user = userDao.getById(id);
        model.addAttribute("user", user);

        return "delete-profile";
    }

    @PostMapping("/profile/delete/{id}")
    public String deleteReviewById(@PathVariable int id) {
        userDao.deleteById(id);

        return "home";
    }

}

