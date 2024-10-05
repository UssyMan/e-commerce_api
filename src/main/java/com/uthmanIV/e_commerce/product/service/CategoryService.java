package com.uthmanIV.e_commerce.product.service;

import com.uthmanIV.e_commerce.commons.ResourceNotFoundException;
import com.uthmanIV.e_commerce.product.DAO.CategoryDAO;
import com.uthmanIV.e_commerce.product.DTO.CategoryDTO;
import com.uthmanIV.e_commerce.product.entities.Category;
import com.uthmanIV.e_commerce.product.mappers.CategoryMapper;
import com.uthmanIV.e_commerce.product.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements CategoryDAO {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper ;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public Category resolve(String categoryName) {
        // Try to find the category by its name
        return categoryRepository.findByName(categoryName)
                .orElseGet(() -> {
                    // Create and save a new Category if not found
                    Category newCategory = new Category();
                    newCategory.setName(categoryName);
                    newCategory.setDescription("All things" + categoryName);
                    return categoryRepository.save(newCategory);
                });
    }

    @Override
    public Category findCategoryById(int id) {
        return categoryRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found"));
    }

    @Override
    public Category findCategoryByName(String name) {
        return categoryRepository.findByName(name)
                .orElseThrow(()-> new ResourceNotFoundException("Not found"));
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addNewCategory(CategoryDTO dto) {
        return Optional.of(categoryMapper.toEntity(dto))
                .filter(categoryDTO -> !categoryRepository.existsByName(dto.name()))
                .map(categoryRepository::save)
                .orElseThrow(()-> new ResourceNotFoundException("Category already Exists"));
    }
    @Override
    public Category updateExistingCategory(CategoryDTO dto){
        return categoryRepository.findByName(dto.name())
                .map(category -> {
                    category.setDescription(dto.description());
                    categoryRepository.save(category);
                    return category;
                })
                .orElseThrow(()-> new ResourceNotFoundException("Category not found"));
    }

    @Override
    public void deleteCategory(String categoryName) {
         categoryRepository
                 .findByName(categoryName)
                 .ifPresentOrElse(categoryRepository::delete,() -> {
                     throw  new ResourceNotFoundException("Category not found");
                 });
    }
}
