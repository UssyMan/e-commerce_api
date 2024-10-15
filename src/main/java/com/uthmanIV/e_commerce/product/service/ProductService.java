package com.uthmanIV.e_commerce.product.service;

import com.uthmanIV.e_commerce.commons.ResourceNotFoundException;
import com.uthmanIV.e_commerce.product.DAO.ProductDAO;
import com.uthmanIV.e_commerce.product.DTO.ProductDTO;
import com.uthmanIV.e_commerce.product.DTO.ProductResponseDTO;
import com.uthmanIV.e_commerce.product.entities.Category;
import com.uthmanIV.e_commerce.product.entities.Product;
import com.uthmanIV.e_commerce.product.mappers.ProductMapper;
import com.uthmanIV.e_commerce.product.repositories.CategoryRepository;
import com.uthmanIV.e_commerce.product.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductDAO {

    private final ProductRepository productRepository;

    private final CategoryService categoryService;

    private final ProductMapper productMapper;

    private final CategoryRepository categoryRepository;


    @Override
    public ProductResponseDTO addProduct(ProductDTO dto) {
        if (productRepository.existsByName(dto.name())) {
            throw new ResourceNotFoundException("Product already exists");
        }

        Product product = productMapper.toEntity(dto);

        Category category = categoryService.resolve(dto.categoryName());
        product.setCategory(category);

        Product savedProduct = productRepository.save(product);

        return productMapper.toDto(savedProduct);
    }

    @Override
    public ProductResponseDTO findProductById(int id) {
        return productRepository.findById(id)
                .map(productMapper::toDto)
                .orElseThrow(()-> new ResourceNotFoundException("Product not found"));
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
                .orElseThrow(()-> new ResourceNotFoundException("Product Not Found"));
    }

    @Override
    public Product findProductByName(String name) {
        return productRepository.findByName(name)
                .orElseThrow(()-> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public List<ProductResponseDTO> findByCategory(String categoryName) {
        return Optional.ofNullable(categoryService.findCategoryByName(categoryName))
                .map(category -> productRepository.findByCategoryName(categoryName)) // Fetch products by category name
                .map(productMapper::toDtoList) // Map the product entities to DTOs
                .orElseThrow(() -> new ResourceNotFoundException("Category not found or no products available for this category"));
    }

    @Override
    public int stock(int productId) {
        Optional<Product> optional= Optional.ofNullable(productRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product not found")));
        if (optional.isPresent()){
            return optional.get().getStock();
        }
        else{
            throw new ResourceNotFoundException("product not found");
        }
    }

}
