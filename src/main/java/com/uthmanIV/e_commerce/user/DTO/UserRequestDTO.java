package com.uthmanIV.e_commerce.user.DTO;



public record UserRequestDTO(
        String email,
        String password,
        String firstName,
        String lastName
) {
}
