package com.uthmanIV.e_commerce.product.service;

import com.uthmanIV.e_commerce.product.DAO.ProductDAO;
import com.uthmanIV.e_commerce.product.DTO.ProductDTO;
import com.uthmanIV.e_commerce.product.DTO.ProductResponseDTO;
import com.uthmanIV.e_commerce.product.entities.Product;
import com.uthmanIV.e_commerce.product.mappers.ProductMapper;
import com.uthmanIV.e_commerce.product.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductDAO {
    private final ProductRepository productRepository;

    private final CategoryService categoryService;

    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, CategoryService categoryService, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.productMapper = productMapper;
    }

    @Override
    public ProductResponseDTO addProduct(ProductDTO dto) {
        return Optional
                .of(productMapper.toEntity(dto))
                .filter(p -> !productRepository.existsByName(dto.name()))
                .map(productRepository::save)
                .map(productMapper::toDto)
                .orElseThrow(()-> new RuntimeException("Product already exists"));
    }

    @Override
    public ProductResponseDTO findProductById(int id) {
        return productRepository.findById(id)
                .map(productMapper::toDto)
                .orElseThrow(()-> new RuntimeException("Product not found"));
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return productMapper
                .toDtoList(productRepository.findAll());
    }

    @Override
    public ProductResponseDTO updateProduct(ProductDTO dto) {
        return Optional
                .ofNullable(findProductByName(dto.name()))
                .map(existingProduct -> {
                    existingProduct.setName(dto.name());
                    existingProduct.setCategory(categoryService.resolve(dto.categoryName()));
                    existingProduct.setPrice(dto.price());
                    existingProduct.setDescription(dto.description());
                    return productMapper.toDto(productRepository.save(existingProduct));
                })
                .orElseThrow(()-> new RuntimeException("Product Not Found"));
    }

    @Override
    public Product findProductByName(String name) {
        return productRepository.findByName(name)
                .orElseThrow(()-> new RuntimeException("Product not found"));
    }

    @Override
    public List<ProductResponseDTO> findByCategory(String category) {
        return productMapper
                .toDtoList(productRepository.findByCategory(category));
    }
}
