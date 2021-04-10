package com.tripaneer.catalog.service;

import jdk.jfr.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getTopCategories();

    List<Category> getCategoryDetails(List<String> categorySlugList);

}
