package com.tripaneer.catalog.service.impl;

import com.tripaneer.catalog.dto.CategoryDTO;
import com.tripaneer.catalog.dto.DestinationDTO;
import com.tripaneer.catalog.response.HomePageResponse;
import com.tripaneer.catalog.service.CategoryService;
import com.tripaneer.catalog.service.DestinationService;
import com.tripaneer.catalog.service.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomePageServiceImpl implements HomePageService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private DestinationService destinationService;

    @Override
    public HomePageResponse getHomePage() {

        List<CategoryDTO> topCategories = categoryService.getTopCategories();
        List<DestinationDTO> topDestinations = destinationService.getTopDestination();
        return HomePageResponse.builder()
                .categoryList(topCategories)
                .destinationList(topDestinations)
                .build();
    }

}
