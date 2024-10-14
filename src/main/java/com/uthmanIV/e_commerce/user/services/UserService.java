package com.uthmanIV.e_commerce.user.services;

import com.uthmanIV.e_commerce.commons.BadRequestException;
import com.uthmanIV.e_commerce.commons.ResourceNotFoundException;
import com.uthmanIV.e_commerce.user.DTO.UserRequestDTO;
import com.uthmanIV.e_commerce.user.DTO.UserResponseDTO;
import com.uthmanIV.e_commerce.user.entities.Role;
import com.uthmanIV.e_commerce.user.entities.User;
import com.uthmanIV.e_commerce.user.utils.UserDAO;
import com.uthmanIV.e_commerce.user.utils.UserMapper;
import com.uthmanIV.e_commerce.user.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService{

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public List<UserResponseDTO> getAll() {

        return userMapper
                .toDto(userRepository.findAll());
    }

    public UserResponseDTO findById(int id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(()-> new ResourceNotFoundException("User not found"));
    }

    public UserResponseDTO createUser(UserRequestDTO user) {
        if (userRepository.existsByEmail(user.email())) {
            throw new BadRequestException("User already exists");
        }

        User newUser = userMapper.toEntity(user);
        User savedUser = userRepository.save(newUser);

        return userMapper.toDto(savedUser);
    }

    public UserResponseDTO findByEmail(String email) {
       return userRepository
               .findByEmail(email)
               .map(userMapper::toDto)
               .orElseThrow(()-> new ResourceNotFoundException("User not found"));
    }

    public UserResponseDTO updateUser(UserRequestDTO dto) {
        return userRepository
                .findByEmail(dto.email())
                .map(user -> {
                    user.setEmail(dto.email());
                    user.setFirstName(dto.firstName());
                    user.setLastName(dto.lastName());
                    userRepository.save(user);
                    return userMapper.toDto(user);
                })
                .orElseThrow(()-> new ResourceNotFoundException("User not Found"));
    }

    public UserResponseDTO deleteUser(Integer id) {
        return userRepository.findById(id)
                .map(user ->{
                    userRepository.delete(user);
                    return userMapper.toDto(user);
                })
                .orElseThrow(()-> new ResourceNotFoundException("User not found"));
    }

    public List<UserResponseDTO> findByRole(Role role) {
        return userMapper.
                toDto(userRepository.findByRoles(role));

    }
}
