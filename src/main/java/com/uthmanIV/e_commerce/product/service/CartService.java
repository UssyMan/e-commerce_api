package com.uthmanIV.e_commerce.product.service;

import com.uthmanIV.e_commerce.product.DAO.CartDAO;
import com.uthmanIV.e_commerce.product.DTO.CartItemDTO;
import com.uthmanIV.e_commerce.product.repositories.CartRepository;
import com.uthmanIV.e_commerce.product.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService implements CartDAO {
    private final CartRepository cartRepository;

    private final ProductRepository productRepository;

    public CartService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void addCartItem(CartItemDTO dto) {

    }

    @Override
    public void removeItemFromCart(CartItemDTO dto) {

    }

    @Override
    public void clearCart(Integer cartId) {

    }
}
