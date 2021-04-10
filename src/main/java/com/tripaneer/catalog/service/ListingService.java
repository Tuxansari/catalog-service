package com.tripaneer.catalog.service;


import com.tripaneer.catalog.dto.ListingDTO;
import com.tripaneer.catalog.model.Listing;

import java.util.List;

public interface ListingService {

    public List<ListingDTO> getListingDTO(String destinationKey);
    public List<Listing> getListing(String destinationKey);
}
