package com.uthmanIV.e_commerce.product.mappers;

import com.uthmanIV.e_commerce.product.DTO.CategoryDTO;
import com.uthmanIV.e_commerce.product.entities.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel ="spring")
public interface CategoryMapper {
    Category toEntity(CategoryDTO dto);
}
