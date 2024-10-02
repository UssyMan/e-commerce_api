package com.uthmanIV.e_commerce.product.DAO;

import com.uthmanIV.e_commerce.product.DTO.CategoryDTO;
import com.uthmanIV.e_commerce.product.entities.Category;

import java.util.List;

public interface CategoryDAO {
    Category findCategoryById(int id);
    Category findCategoryByName(String name);
    List<Category> getAllCategories();
    Category addNewCategory(CategoryDTO dto);
    void deleteCategory(String categoryName);
}
