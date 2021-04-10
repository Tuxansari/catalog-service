package com.tripaneer.catalog.service;

import com.tripaneer.catalog.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getTopCategories();

    List<CategoryDTO> getCategoryDetails(List<String> categorySlugList);

}
