package com.uthmanIV.e_commerce.product.service;

import com.uthmanIV.e_commerce.commons.ResourceNotFoundException;
import com.uthmanIV.e_commerce.product.DAO.CartDAO;
import com.uthmanIV.e_commerce.product.DTO.CartItemDTO;
import com.uthmanIV.e_commerce.product.DTO.ProductResponseDTO;
import com.uthmanIV.e_commerce.product.entities.Cart;
import com.uthmanIV.e_commerce.product.entities.CartItem;
import com.uthmanIV.e_commerce.product.repositories.CartItemRepository;
import com.uthmanIV.e_commerce.product.repositories.CartRepository;
import com.uthmanIV.e_commerce.product.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CartService implements CartDAO {
    private final CartRepository cartRepository;

    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;

    public CartService(
            CartRepository cartRepository,
            ProductRepository productRepository,
            CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
    }


    @Override
    public List<ProductResponseDTO> productsInCart(int cartId) {
        return null;
    }

    @Override
    public CartItemDTO updateCartItemQuantity(int cartItemId, int quantityId) {
        return null;
    }

    @Override
    public void addCartItem(CartItemDTO dto) {

    }

    @Override
    public void removeItemFromCart(int cartItemId, int cartId) {
        // Fetch the Cart
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart with id " + cartId + " not found"));

        // Fetch the CartItem
        CartItem cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new ResourceNotFoundException("CartItem with id " + cartItemId + " not found"));

        // Remove the CartItem from the Cart's items list
        boolean removed = cart.getCartItems().remove(cartItem);

        if (!removed) {
            throw new ResourceNotFoundException("CartItem with id " + cartItemId + " not found in the cart");
        }
        // Save the updated Cart
        cartRepository.save(cart);
    }


    @Override
    public void clearCart(Integer cartId) {
        cartRepository.findById(cartId)
                .ifPresent(cart -> cart.getCartItems().clear());  // Clear all cart items
    }


    @Override
    public BigDecimal cartTotalPrice(int cartId) {
        return null;
    }
}
