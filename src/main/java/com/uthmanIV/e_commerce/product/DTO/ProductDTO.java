package com.uthmanIV.e_commerce.product.DTO;

import com.uthmanIV.e_commerce.product.entities.Category;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductDTO(

        @NotNull String name,
        String description,
        BigDecimal price,
        String categoryName
) {
}
