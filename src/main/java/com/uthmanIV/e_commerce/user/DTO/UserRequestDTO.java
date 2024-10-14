package com.uthmanIV.e_commerce.user.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(@NotNull @Email String email,
                             @NotBlank String password,
                             @NotNull @Size(min = 3,max = 64) String firstName,
                             @NotNull @Size(min = 3,max = 64) String lastName) {}
