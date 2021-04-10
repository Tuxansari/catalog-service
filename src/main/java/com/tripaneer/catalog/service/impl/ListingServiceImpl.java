package com.tripaneer.catalog.service.impl;

import com.tripaneer.catalog.dto.ListingDTO;
import com.tripaneer.catalog.domain.Listing;
import com.tripaneer.catalog.repository.ListingRepository;
import com.tripaneer.catalog.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListingServiceImpl implements ListingService {

    @Autowired
    private ListingRepository listingRepository;

    @Override
    public List<Listing> getListingByDestination(String destinationKey) {
        return new ArrayList<>(listingRepository
                .findAllByDestinationKey(destinationKey));
    }

    @Override
    public List<ListingDTO> getListingDTOByCategory(String categoryKey) {
        return listingRepository.findAllByCategoryKey(categoryKey)
                .stream()
                .limit(10)
                .map(this::convertToListingDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ListingDTO> getListingDTOByDestination(String destinationKey) {
        return getListingByDestination(destinationKey)
                .stream()
                .limit(10)
                .map(this::convertToListingDTO)
                .collect(Collectors.toList());
    }

    private ListingDTO convertToListingDTO(Listing listing) {
        return ListingDTO.builder()
                .title(listing.getTitle())
                .slug(listing.getSlug())
                .price(listing.getPriceEuro())
                .build();
    }
}
