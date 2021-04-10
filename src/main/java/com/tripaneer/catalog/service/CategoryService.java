package com.tripaneer.catalog.service;

import com.tripaneer.catalog.dto.CategoryDTO;
import com.tripaneer.catalog.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getTopCategories();

    List<CategoryDTO> getCategoryDetails(List<String> categorySlugList);

    CategoryResponse getCategory(String categoryKey);
}
