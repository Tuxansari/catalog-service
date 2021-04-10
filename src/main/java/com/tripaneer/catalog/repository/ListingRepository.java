package com.tripaneer.catalog.repository;

import com.tripaneer.catalog.model.Listing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingRepository extends MongoRepository<Listing, String> {
    List<Listing> findAllBySlug(String slug);
}
