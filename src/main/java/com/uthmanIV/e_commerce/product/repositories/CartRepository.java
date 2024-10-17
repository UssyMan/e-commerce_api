package com.uthmanIV.e_commerce.product.repositories;

import com.uthmanIV.e_commerce.product.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    Optional<Cart> findByCartItemsId(int cartItemId);
}
