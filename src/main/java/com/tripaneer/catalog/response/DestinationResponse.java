package com.tripaneer.catalog.response;

import com.tripaneer.catalog.dto.CategoryDTO;
import com.tripaneer.catalog.dto.DestinationDTO;
import com.tripaneer.catalog.dto.ListingDTO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class DestinationResponse extends BaseResponse {
    private List<ListingDTO> listings;
    private List<DestinationDTO> subDestinations;
    private List<CategoryDTO> categories;
}
