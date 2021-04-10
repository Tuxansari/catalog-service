package com.tripaneer.catalog.service;

import com.tripaneer.catalog.dto.DestinationDTO;
import com.tripaneer.catalog.response.DestinationResponse;

import java.util.List;


public interface DestinationService {
    List<DestinationDTO> getTopDestination();

    DestinationResponse getDestination(String destinationKey);
}
