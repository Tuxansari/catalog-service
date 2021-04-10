package com.tripaneer.catalog.repository;

import com.tripaneer.catalog.domain.Listing;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingRepository extends MongoRepository<Listing, String> {
    @Cacheable("listing")
    @Query("{ taggedDestinations: ?0 }")
    List<Listing> findAllByDestinationKey(String destinationKey);

    @Cacheable("listing")
    @Query("{ taggedCategories: ?0 }")
    List<Listing> findAllByCategoryKey(String categoryKey);
}
