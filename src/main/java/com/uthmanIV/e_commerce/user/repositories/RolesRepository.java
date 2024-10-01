package com.uthmanIV.e_commerce.user.repositories;

import com.uthmanIV.e_commerce.user.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface RolesRepository extends JpaRepository<Role,Integer> {
}
