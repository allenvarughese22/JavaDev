package com.example.demo.controller;

import com.example.demo.Service.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {

    @Autowired
    Data coronoVirusDataService;
    @GetMapping("/")

    public  String home(Model model)
    {
        model.addAttribute("locationStats",coronoVirusDataService.getAllStats());
        return"home";
    }

}
