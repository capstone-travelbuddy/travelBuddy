package com.capstone.travelbuddy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class landingPageController {

    @GetMapping("/landingPage")
    public String getCitiesView(Model model) {

        return "landingPage";
    }
}
