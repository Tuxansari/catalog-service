package com.tripaneer.catalog.service.impl;

import com.tripaneer.catalog.dto.CategoryDTO;
import com.tripaneer.catalog.model.Category;
import com.tripaneer.catalog.repository.CategoryRepository;
import com.tripaneer.catalog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

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

    private CategoryDTO convertToCategoryDTO(Category category) {
        return CategoryDTO.builder()
                .name(category.getName())
                .slug(category.getSlug())
                .build();
    }

    @Override
    public List<CategoryDTO> getCategoryDetails(List<String> categorySlugList) {
        return Collections.emptyList();
    }
}
