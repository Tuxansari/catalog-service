package com.tripaneer.catalog.response;

import com.tripaneer.catalog.dto.CategoryDTO;
import com.tripaneer.catalog.dto.DestinationDTO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class HomePageResponse extends BaseResponse {
    private List<CategoryDTO> categoryList;
    private List<DestinationDTO> destinationList;

}
