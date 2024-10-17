package com.uthmanIV.e_commerce.product.repositories;


import com.uthmanIV.e_commerce.product.entities.Category;
import com.uthmanIV.e_commerce.product.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    Optional<Product> findByName(String name);

    List<Product> findByCategoryName(String categoryName);

    boolean existsByName(String name);
}
