package com.uthmanIV.e_commerce.product.mappers;

import com.uthmanIV.e_commerce.product.DTO.ProductDTO;
import com.uthmanIV.e_commerce.product.DTO.ProductResponseDTO;
import com.uthmanIV.e_commerce.product.entities.Product;
import com.uthmanIV.e_commerce.product.service.CategoryService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel ="spring", uses = CategoryService.class)
public interface ProductMapper {
    @Mapping(source = "categoryName", target = "category.name")
    Product toEntity(ProductDTO dto);
    ProductResponseDTO toDto(Product product);
    List<ProductResponseDTO> toDtoList(List<Product> product);
}
