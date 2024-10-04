package com.uthmanIV.e_commerce.product.controllers;


import com.uthmanIV.e_commerce.product.DTO.CategoryDTO;
import com.uthmanIV.e_commerce.product.DTO.ProductDTO;
import com.uthmanIV.e_commerce.product.DTO.ProductResponseDTO;
import com.uthmanIV.e_commerce.product.entities.Category;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @GetMapping
    public ResponseEntity<ProductResponseDTO> allProducts(){
        return null;
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable int id){
        return null;
    }

    @GetMapping
    public ResponseEntity<ProductResponseDTO> getProductByName(@RequestParam String name){
        return null;
    }
    @GetMapping("/category-products")
    public ResponseEntity<List<ProductResponseDTO>> productsInACategory(){
        return null;
    }
    @PostMapping
    public ResponseEntity<ProductResponseDTO> addProduct(){
        return null;
    }
    @PutMapping
    public ResponseEntity<ProductResponseDTO> updateProduct(@RequestBody ProductDTO dto){
        return null;
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ProductResponseDTO> deleteProduct(@PathVariable int id){
        return null;
    }
    @GetMapping("/categories")
    public ResponseEntity<Category> getCategories(){
        return null;
    }
    @GetMapping("/categories/{name}")
    public ResponseEntity<Category> getCategoryByName(@PathVariable String name){
        return null; // probably delete this method
    }
    @PostMapping("/categories")
    public ResponseEntity<Category> addCategory(@RequestBody CategoryDTO name){
        return null;
    }
    @PutMapping("/categories")
    public ResponseEntity<Category> updateCategory(@RequestBody CategoryDTO dto){
        return null;
    }
    @DeleteMapping("/categories/{name}")
    public ResponseEntity<Void> delete(@PathVariable String categoryName){
        return null;
    }

}
