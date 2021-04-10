package com.tripaneer.catalog.repository;

import com.tripaneer.catalog.model.Destination;
import com.tripaneer.catalog.model.Listing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinationRepository extends MongoRepository<Destination, String> {
    List<Destination> findAllByParentSlug(String parentSlug);
}
