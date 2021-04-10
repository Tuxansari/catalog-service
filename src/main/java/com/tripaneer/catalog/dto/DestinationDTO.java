package com.tripaneer.catalog.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DestinationDTO {
    private String name;
    private String slug;
}
