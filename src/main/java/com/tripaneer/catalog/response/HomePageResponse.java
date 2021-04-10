package com.tripaneer.catalog.response;

import com.tripaneer.catalog.dto.CategoryDTO;
import com.tripaneer.catalog.dto.DestinationDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class HomePageResponse {
    private List<CategoryDTO> categoryList;
    private List<DestinationDTO> destinationList;

}
