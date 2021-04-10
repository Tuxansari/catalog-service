package com.tripaneer.catalog.service.impl;

import com.tripaneer.catalog.dto.DestinationDTO;
import com.tripaneer.catalog.model.Destination;
import com.tripaneer.catalog.model.Listing;
import com.tripaneer.catalog.dto.ListingDTO;
import com.tripaneer.catalog.repository.DestinationRepository;
import com.tripaneer.catalog.repository.ListingRepository;
import com.tripaneer.catalog.response.DestinationResponse;
import com.tripaneer.catalog.service.CategoryService;
import com.tripaneer.catalog.service.DestinationService;
import com.tripaneer.catalog.service.ListingService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DestinationServiceImpl implements DestinationService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ListingService listingService;

    @Autowired
    private DestinationRepository destinationRepository;

    @Override
    public List<DestinationDTO> getTopDestination() {
        return Collections.emptyList();
    }

    @Override
    public DestinationResponse getDestination(String destinationKey) {
        return DestinationResponse.builder()
                .listings(listingService.getListingDTO(destinationKey))
                .subDestinations(getSubDestinations(destinationKey))
                .categories(getCategories(destinationKey))
                .build();
    }

    private List<DestinationDTO> getSubDestinations(String destinationKey) {
        return destinationRepository
                .findAllByParentSlug(destinationKey)
                .stream()
                .map(this::convertToDestinationDTO)
                .limit(8)
                .collect(Collectors.toList());
    }

    private DestinationDTO convertToDestinationDTO(Destination destination) {
        return DestinationDTO.builder()
                .name(destination.getName())
                .slug(destination.getSlug())
                .build();
    }

    private List<Category> getCategories(String destinationKey) {
        List<String> categorySlugList = new ArrayList<>();
        List<Listing> listings = listingService.getListing(destinationKey);
        listings.forEach(value -> categorySlugList.addAll(value.getTaggedCategories()));
        return categoryService.getCategoryDetails(categorySlugList);
    }
}
