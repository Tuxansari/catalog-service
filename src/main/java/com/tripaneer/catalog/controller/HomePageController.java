package com.tripaneer.catalog.controller;

import com.tripaneer.catalog.response.HomePageResponse;
import com.tripaneer.catalog.service.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {

    @Autowired
    private HomePageService homePageService;

    @GetMapping("/homepage")
    public HomePageResponse getHomePage() {
        return homePageService.getHomePage();
    }
}
