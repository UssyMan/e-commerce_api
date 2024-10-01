package com.uthmanIV.e_commerce.product.repositories;

import com.uthmanIV.e_commerce.product.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Optional<Product> findByName(String name);
    List<Product> findByCategory(String category);

    boolean existsByName(String name);
}
