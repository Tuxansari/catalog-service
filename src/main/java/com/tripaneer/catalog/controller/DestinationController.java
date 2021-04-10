package com.tripaneer.catalog.controller;

import com.tripaneer.catalog.response.DestinationResponse;
import com.tripaneer.catalog.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @GetMapping("/destination/{key}")
    public Mono<DestinationResponse> getDestination(@PathVariable(value = "key") String destinationKey) {
        return destinationService.getDestination(destinationKey);
    }
}
