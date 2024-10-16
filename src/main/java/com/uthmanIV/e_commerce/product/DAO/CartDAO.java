package com.uthmanIV.e_commerce.product.DAO;

import com.uthmanIV.e_commerce.product.DTO.CartItemDTO;
import com.uthmanIV.e_commerce.product.DTO.ProductResponseDTO;

import java.math.BigDecimal;
import java.util.List;

public interface CartDAO {
    List<ProductResponseDTO> productsInCart(int cartId);
    void updateCartItemQuantity(int cartItemId,int newQuantity);
    void addCartItem(CartItemDTO dto);
    void removeItemFromCart(int cartItemId,int cartId);
    void clearCart(Integer cartId);
    BigDecimal cartTotalPrice(int cartId);
}
