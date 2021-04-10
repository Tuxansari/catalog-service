package com.tripaneer.catalog.service;

import com.tripaneer.catalog.response.HomePageResponse;
import reactor.core.publisher.Mono;

public interface HomePageService {
    Mono<HomePageResponse> buildHomePage();
}
