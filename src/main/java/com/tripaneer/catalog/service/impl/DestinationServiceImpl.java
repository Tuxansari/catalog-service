package com.tripaneer.catalog.service.impl;

import com.tripaneer.catalog.dto.CategoryDTO;
import com.tripaneer.catalog.dto.DestinationDTO;
import com.tripaneer.catalog.domain.Destination;
import com.tripaneer.catalog.domain.Listing;
import com.tripaneer.catalog.repository.DestinationRepository;
import com.tripaneer.catalog.response.DestinationResponse;
import com.tripaneer.catalog.service.CategoryService;
import com.tripaneer.catalog.service.DestinationService;
import com.tripaneer.catalog.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
        return destinationRepository
                .findAll()
                .stream()
                .limit(10)
                .map(this::convertToDestinationDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DestinationResponse getDestination(String destinationKey) {
        return DestinationResponse.builder()
                .listings(listingService.getListingDTOByDestination(destinationKey))
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

    private List<CategoryDTO> getCategories(String destinationKey) {
        List<String> categorySlugList = new ArrayList<>();
        List<Listing> listings = listingService.getListingByDestination(destinationKey);
        listings.stream()
                .limit(10)
                .map(Listing::getTaggedCategories)
                .filter(Objects::nonNull).forEach(categorySlugList::addAll);
        return categoryService.getCategoryDetails(categorySlugList);
    }
}
