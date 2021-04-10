package com.tripaneer.catalog.controller;

import com.tripaneer.catalog.response.CategoryResponse;
import com.tripaneer.catalog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/{key}")
    public CategoryResponse getCategory(@PathVariable(value = "key") String categoryKey) {
        return categoryService.getCategory(categoryKey);
    }
}
