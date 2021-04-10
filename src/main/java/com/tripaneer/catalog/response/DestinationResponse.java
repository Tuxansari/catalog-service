package com.tripaneer.catalog.response;

import com.tripaneer.catalog.dto.DestinationDTO;
import com.tripaneer.catalog.dto.ListingDTO;
import jdk.jfr.Category;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DestinationResponse {
    private List<ListingDTO> listings;
    private List<DestinationDTO> subDestinations;
    private List<Category> categories;
}
