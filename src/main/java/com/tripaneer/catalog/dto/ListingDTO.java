package com.tripaneer.catalog.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ListingDTO {
    private String title;
    private String slug;
    private Double price;
}
