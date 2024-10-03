package com.uthmanIV.e_commerce.user.services;

import com.uthmanIV.e_commerce.user.DTO.UserRequestDTO;
import com.uthmanIV.e_commerce.user.DTO.UserResponseDTO;
import com.uthmanIV.e_commerce.user.entities.Role;
import com.uthmanIV.e_commerce.user.entities.User;
import com.uthmanIV.e_commerce.user.utils.UserDAO;
import com.uthmanIV.e_commerce.user.utils.UserMapper;
import com.uthmanIV.e_commerce.user.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDAO {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserResponseDTO> getAll() {

        return userMapper
                .toDto(userRepository.findAll());
    }

    @Override
    public UserResponseDTO findById(int id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(()-> new RuntimeException("User not found"));
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO user) {
        if (userRepository.existsByEmail(user.email())) {
            throw new RuntimeException("User already exists");
        }

        User newUser = userMapper.toEntity(user);
        User savedUser = userRepository.save(newUser);

        return userMapper.toDto(savedUser);
    }


    @Override
    public UserResponseDTO findByEmail(String email) {
       return userRepository
               .findByEmail(email)
               .map(userMapper::toDto)
               .orElseThrow(()-> new RuntimeException("User not found"));
    }

    @Override
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
                .orElseThrow(()-> new RuntimeException("User not Found"));
    }

    @Override
    public UserResponseDTO deleteUser(Integer id) {
        return userRepository.findById(id)
                .map(user ->{
                    userRepository.delete(user);
                    return userMapper.toDto(user);
                })
                .orElseThrow(()-> new RuntimeException("User not found"));
    }

    @Override
    public List<UserResponseDTO> findByRole(Role role) {
        return userMapper.
                toDto(userRepository.findByRoles(role));

    }
}
