package com.uthmanIV.e_commerce.product.repositories;

import com.uthmanIV.e_commerce.product.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
}
