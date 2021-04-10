package com.tripaneer.catalog.repository;

import com.tripaneer.catalog.domain.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
    List<Category> findAllBySlug(String slug);

    List<Category> findAllBySlugIn(List<String> slugList);
}
