package com.uthmanIV.e_commerce.product.DTO;

import com.uthmanIV.e_commerce.product.entities.Category;

import java.math.BigDecimal;

public record ProductDTO(
        String name,
        String description,
        BigDecimal price,
        Category category
) {
}
