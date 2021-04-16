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

    /*
    http://localhost:8081/health
    http://localhost:8081/destination/magna-finibus-velit-integer
    http://localhost:8081/category/accumsan-aliquam
    http://localhost:8081/homepage
    https://fameoflight.atlassian.net/wiki/spaces/CS/pages/65542/Assignment+-+Landing+Page
    http://localhost:8888/sources/1/dashboards/9?refresh=5s&lower=now%28%29%20-%205m
     */
}
