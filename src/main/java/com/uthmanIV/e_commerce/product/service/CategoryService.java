package com.uthmanIV.e_commerce.product.service;

import com.uthmanIV.e_commerce.product.DTO.CategoryDTO;
import com.uthmanIV.e_commerce.product.entities.Category;
import com.uthmanIV.e_commerce.product.repositories.CategoryRepository;

public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category resolve(String categoryName) {
        // Try to find the category by its name
        return categoryRepository.findByName(categoryName)
                .orElseGet(() -> {
                    // Create and save a new Category if not found
                    Category newCategory = new Category();
                    newCategory.setName(categoryName);
                    return categoryRepository.save(newCategory);
                });
    }

}
