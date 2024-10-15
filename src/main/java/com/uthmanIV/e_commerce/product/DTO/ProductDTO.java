package com.uthmanIV.e_commerce.product.DTO;

import com.uthmanIV.e_commerce.product.entities.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductDTO(

        @NotBlank @Size(min = 3, max = 64)
        String name,
        @NotBlank @Size(min = 3)
        String description,
        @NotNull
        BigDecimal price,
        @NotBlank @Size(min = 4)
        String categoryName
) {
}
