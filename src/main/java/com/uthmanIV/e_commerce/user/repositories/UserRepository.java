package com.uthmanIV.e_commerce.user.repositories;

import com.uthmanIV.e_commerce.user.entities.Role;
import com.uthmanIV.e_commerce.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

    List<User> findByRoles(Role role);
}
