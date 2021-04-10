package com.tripaneer.catalog.service.impl;

import com.tripaneer.catalog.service.CategoryService;
import jdk.jfr.Category;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> getTopCategories() {
        return Collections.emptyList();
    }

    @Override
    public List<Category> getCategoryDetails(List<String> categorySlugList) {
        return null;
    }
}
