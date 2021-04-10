package com.tripaneer.catalog.repository;

import com.tripaneer.catalog.domain.Category;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
    @Cacheable("category")
    List<Category> findAllBySlugIn(List<String> slugList);
}
