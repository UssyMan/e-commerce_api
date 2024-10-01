package com.uthmanIV.e_commerce.product.DTO;

import com.uthmanIV.e_commerce.product.entities.Category;
import com.uthmanIV.e_commerce.product.entities.Image;

import java.math.BigDecimal;
import java.util.List;

public record ProductResponseDTO(
        String name,
        String description,
        BigDecimal price,
        Category category,
        List<Image> images
) {
}
