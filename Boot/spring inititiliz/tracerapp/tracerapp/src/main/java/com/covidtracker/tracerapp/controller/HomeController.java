package com.covidtracker.tracerapp.controller;

import com.covidtracker.tracerapp.Service.Data;
import com.covidtracker.tracerapp.models.LocationDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    Data coronaVirusDataService ;
    @GetMapping("/")

    public String home(Model model)
    {
        List<LocationDataSet> allStats= coronaVirusDataService.getAllStats();
        int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getTotalCases()).sum();
        model.addAttribute("locationStats",allStats);
        model.addAttribute("totalReportedCases",totalReportedCases);

        return "home";
    }

}
