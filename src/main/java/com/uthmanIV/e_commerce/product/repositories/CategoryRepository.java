package com.uthmanIV.e_commerce.product.repositories;

import com.uthmanIV.e_commerce.product.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Optional<Category> findByName(String categoryName);

    boolean existsByName(String name);
}
