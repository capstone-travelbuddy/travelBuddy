package com.capstone.travelbuddy.controller;

import com.capstone.travelbuddy.model.User;
import com.capstone.travelbuddy.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}

