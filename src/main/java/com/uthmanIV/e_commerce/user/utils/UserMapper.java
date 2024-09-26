package com.uthmanIV.e_commerce.user.utils;

import com.uthmanIV.e_commerce.user.DTO.UserRequestDTO;
import com.uthmanIV.e_commerce.user.DTO.UserResponseDTO;
import com.uthmanIV.e_commerce.user.entities.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel ="spring")
public interface UserMapper {

    UserResponseDTO toDto(User user);

    User toEntity(UserRequestDTO dto);

    List<UserResponseDTO> toDto(List<User> users);

    User toEntity(UserResponseDTO dto);



}
