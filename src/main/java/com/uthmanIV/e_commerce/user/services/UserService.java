package com.uthmanIV.e_commerce.user.services;

import com.uthmanIV.e_commerce.user.DTO.UserRequestDTO;
import com.uthmanIV.e_commerce.user.DTO.UserResponseDTO;
import com.uthmanIV.e_commerce.user.entities.Roles;
import com.uthmanIV.e_commerce.user.entities.User;
import com.uthmanIV.e_commerce.user.utils.UserDAO;
import com.uthmanIV.e_commerce.user.utils.UserMapper;
import com.uthmanIV.e_commerce.user.repositories.UserRepository;
import org.springframework.stereotype.Service;

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
    public UserResponseDTO findById(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            return userMapper.toDto(optionalUser.get());
        }
        else{
            throw new RuntimeException("User not found with id -" + id);
        }
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO user) {

        if (userRepository.existsByEmail(user.email())){
            throw new RuntimeException("User exists");
        }
        else{
            User newUser = userMapper.toEntity(user);
            userRepository.save(newUser);
            return userMapper.toDto(newUser);
        }
    }

    @Override
    public UserResponseDTO findByEmail(String email) {
        User user = null;
        if (userRepository.findByEmail(email).isPresent()){

            user = userRepository.findByEmail(email).get();

            return userMapper.toDto(user);
        }
        else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public UserResponseDTO updateUser(UserRequestDTO user) {
        return null;
    }

    @Override
    public UserResponseDTO deleteUser(Integer id) {
        User demoUser = userMapper.toEntity(findById(id));
        if (demoUser!= null){
            userRepository.delete(demoUser);
            return userMapper.toDto(demoUser);
        }
        else{
            throw new RuntimeException("User does not exist");
        }
    }

    @Override
    public List<UserResponseDTO> findByRole(Roles role) {
        return userMapper.
                toDto(userRepository.findByRole(role));

    }
}
