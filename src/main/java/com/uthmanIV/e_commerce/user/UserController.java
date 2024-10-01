package com.uthmanIV.e_commerce.user;

import com.uthmanIV.e_commerce.user.DTO.UserRequestDTO;
import com.uthmanIV.e_commerce.user.DTO.UserResponseDTO;
import com.uthmanIV.e_commerce.user.entities.Role;
import com.uthmanIV.e_commerce.user.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findUserById(
            @PathVariable int id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> addNewUser(
            @RequestBody UserRequestDTO dto){
        return ResponseEntity.ok(userService.createUser(dto));
    }

    @GetMapping("/email")
    public ResponseEntity<UserResponseDTO> findUserByEmail(
            @RequestParam String email){
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponseDTO> deleteUser(
            @PathVariable int id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @GetMapping("/roles")
    private ResponseEntity<List<UserResponseDTO>> getUsersByRole(
            @RequestBody Role role){
        return ResponseEntity.ok(userService.findByRole(role));
    }
}
