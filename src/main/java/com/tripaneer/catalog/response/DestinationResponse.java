package com.tripaneer.catalog.response;

import com.tripaneer.catalog.model.ListingDTO;
import jdk.jfr.Category;
import lombok.Builder;
import lombok.Data;

import javax.print.attribute.standard.Destination;
import java.util.List;

@Data
@Builder
public class DestinationResponse {
    private List<ListingDTO> listings;
    private List<Destination> subDestinations;
    private List<Category> categories;
}
