package com.tripaneer.catalog.service.impl;

import com.tripaneer.catalog.dto.ListingDTO;
import com.tripaneer.catalog.model.Listing;
import com.tripaneer.catalog.repository.ListingRepository;
import com.tripaneer.catalog.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListingServiceImpl implements ListingService {

    @Autowired
    private ListingRepository listingRepository;

    @Override
    public List<Listing> getListing(String destinationKey) {
        return new ArrayList<>(listingRepository
                .findAllBySlug(destinationKey));
    }

    @Override
    public List<ListingDTO> getListingDTO(String destinationKey) {
        return getListing(destinationKey).stream()
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
