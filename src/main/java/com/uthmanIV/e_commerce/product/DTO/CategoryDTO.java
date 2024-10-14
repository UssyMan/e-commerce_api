package com.uthmanIV.e_commerce.product.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CategoryDTO(
        @NotNull String name,
        @NotNull @Size(min = 15) String description) {
}
