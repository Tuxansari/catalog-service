package com.tripaneer.catalog.service.impl;

import com.tripaneer.catalog.response.HomePageResponse;
import com.tripaneer.catalog.service.CategoryService;
import com.tripaneer.catalog.service.DestinationService;
import com.tripaneer.catalog.service.HomePageService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.print.attribute.standard.Destination;
import java.util.List;

@Service
public class HomePageServiceImpl implements HomePageService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private DestinationService destinationService;

    @Override
    public Mono<HomePageResponse> buildHomePage() {

        List<Category> topCategories = categoryService.getTopCategories();
        List<Destination> topDestinations = destinationService.getTopDestination();
        return Mono.just(HomePageResponse.builder()
                .categoryList(topCategories)
                .destinationList(topDestinations)
                .build());
    }

}