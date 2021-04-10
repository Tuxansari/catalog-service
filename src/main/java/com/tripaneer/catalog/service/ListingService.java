package com.tripaneer.catalog.service;


import com.tripaneer.catalog.dto.ListingDTO;
import com.tripaneer.catalog.domain.Listing;

import java.util.List;

public interface ListingService {

    List<ListingDTO> getListingDTOByDestination(String destinationKey);
    List<Listing> getListingByDestination(String destinationKey);
    List<ListingDTO> getListingDTOByCategory(String categoryKey);
}
