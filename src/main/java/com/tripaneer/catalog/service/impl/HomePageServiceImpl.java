package com.tripaneer.catalog.service.impl;

import com.tripaneer.catalog.response.HomePageResponse;
import com.tripaneer.catalog.service.CategoryService;
import com.tripaneer.catalog.service.DestinationService;
import com.tripaneer.catalog.service.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomePageServiceImpl implements HomePageService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private DestinationService destinationService;

    @Override
    public HomePageResponse getHomePage() {
        return HomePageResponse.builder()
                .categoryList(categoryService.getTopCategories())
                .destinationList(destinationService.getTopDestination())
                .build();
    }

}
