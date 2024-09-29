package com.uthmanIV.e_commerce.product.DAO;

import com.uthmanIV.e_commerce.product.DTO.CartItemDTO;

public interface CartDAO {
    void addCartItem(CartItemDTO dto);
    void removeItemFromCart(CartItemDTO dto);
    void clearCart(Integer cartId);
}
