package com.tripaneer.catalog.service.impl;

import com.tripaneer.catalog.dto.CategoryDTO;
import com.tripaneer.catalog.domain.Category;
import com.tripaneer.catalog.repository.CategoryRepository;
import com.tripaneer.catalog.response.CategoryResponse;
import com.tripaneer.catalog.service.CategoryService;
import com.tripaneer.catalog.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ListingService listingService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> getTopCategories() {
        return categoryRepository
                .findAll()
                .stream()
                .limit(10)
                .map(this::convertToCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoryDTO> getCategoryDetails(List<String> categorySlugList) {
        return categoryRepository
                .findAllBySlugIn(categorySlugList)
                .stream()
                .map(this::convertToCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryResponse getCategory(String categoryKey) {
        return CategoryResponse.builder()
                .listings(listingService.getListingDTOByCategory(categoryKey))
                .otherCategories(getTopCategories())
                .build();
    }

    private CategoryDTO convertToCategoryDTO(Category category) {
        return CategoryDTO.builder()
                .name(category.getName())
                .slug(category.getSlug())
                .build();
    }
}
