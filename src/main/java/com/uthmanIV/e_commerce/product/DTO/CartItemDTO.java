package com.uthmanIV.e_commerce.product.DTO;

import com.uthmanIV.e_commerce.product.entities.Product;

public record CartItemDTO(
        Product product,
        int quantity
) {
}
