package com.capstone.travelbuddy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CityController {

	@GetMapping("/destinations")
	public String getCitiesView(){
		return "cities";
	}

}
