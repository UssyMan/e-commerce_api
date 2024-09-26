package com.uthmanIV.e_commerce.user.DTO;

import com.uthmanIV.e_commerce.user.entities.Roles;

import java.util.Set;

public record UserResponseDTO(
        Integer id,
        String email,
        String firstName,
        String lastName,
        Set<Roles> roles
) {
}
