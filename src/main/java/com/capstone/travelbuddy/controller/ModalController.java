package com.capstone.travelbuddy.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("modals")
public class ModalController {
    @GetMapping("modals1")
    public String modal1(){
        return "modal1";
    }

}
