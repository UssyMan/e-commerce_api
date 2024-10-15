package com.uthmanIV.e_commerce.product.DTO;

import com.uthmanIV.e_commerce.product.entities.Product;
import jakarta.validation.constraints.NotNull;

public record CartItemDTO(
        Product product,

        @NotNull
        int quantity
) {
}
