package com.tripaneer.catalog.response;

import com.tripaneer.catalog.dto.CategoryDTO;
import com.tripaneer.catalog.dto.ListingDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CategoryResponse extends BaseResponse {
    private List<ListingDTO> listings;
    private List<CategoryDTO> otherCategories;
}
