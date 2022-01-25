package com.capstone.travelbuddy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {

    @Value("${mapbox.api.key}")
    private String mapboxApiKey;


    @GetMapping("/shop")
    public String getShopView(Model model) {

        model.addAttribute("mapboxApikey", mapboxApiKey);

        return "shop";
    }
}
