package com.uthmanIV.e_commerce.product.DAO;

import com.uthmanIV.e_commerce.product.DTO.ProductDTO;
import com.uthmanIV.e_commerce.product.DTO.ProductResponseDTO;
import com.uthmanIV.e_commerce.product.entities.Product;

import java.util.List;

public interface ProductDAO {
    ProductResponseDTO addProduct(ProductDTO dto);
    ProductResponseDTO findProductById(int id);
    List<ProductResponseDTO> getAllProducts();

    ProductResponseDTO updateProduct(ProductDTO dto);

    Product findProductByName(String name);
    List<ProductResponseDTO> findByCategory(String category);
}
