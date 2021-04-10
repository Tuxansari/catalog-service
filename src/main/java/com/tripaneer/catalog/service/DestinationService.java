package com.tripaneer.catalog.service;

import com.tripaneer.catalog.response.DestinationResponse;
import reactor.core.publisher.Mono;

import javax.print.attribute.standard.Destination;
import java.util.List;

public interface DestinationService {
    List<Destination> getTopDestination();

    Mono<DestinationResponse> getDestination(String destinationKey);
}
