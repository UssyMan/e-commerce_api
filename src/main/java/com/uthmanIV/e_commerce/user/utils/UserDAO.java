package com.uthmanIV.e_commerce.user.utils;

import com.uthmanIV.e_commerce.user.DTO.UserRequestDTO;
import com.uthmanIV.e_commerce.user.DTO.UserResponseDTO;
import com.uthmanIV.e_commerce.user.entities.Roles;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDAO {
    List<UserResponseDTO> getAll();
    UserResponseDTO findById(Integer id);

    UserResponseDTO createUser(UserRequestDTO user);

    UserResponseDTO findByEmail(String email);

    UserResponseDTO updateUser(UserRequestDTO user);

    UserResponseDTO deleteUser(Integer id);

    List<UserResponseDTO> findByRole(Roles role);

}
