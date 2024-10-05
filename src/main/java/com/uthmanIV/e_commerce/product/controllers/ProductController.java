package com.uthmanIV.e_commerce.product.controllers;


import com.uthmanIV.e_commerce.product.DTO.CategoryDTO;
import com.uthmanIV.e_commerce.product.DTO.ProductDTO;
import com.uthmanIV.e_commerce.product.DTO.ProductResponseDTO;
import com.uthmanIV.e_commerce.product.entities.Category;
import com.uthmanIV.e_commerce.product.service.CategoryService;
import com.uthmanIV.e_commerce.product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }


    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> allProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable int id){
        return ResponseEntity.ok(productService.findProductById(id));
    }

    @GetMapping("/{productName}")
    public ResponseEntity<ProductResponseDTO> getProductByName(@PathVariable String name){
        return null; //ResponseEntity.ok(productService.findProductByName(name))
        //work on findProductByName() to return ResponseDTO
    }
    @GetMapping("/categories")
    public ResponseEntity<List<Category>>getCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
    @GetMapping("/categories/{categoryName}")
    public ResponseEntity<List<ProductResponseDTO>> productsInACategory(@PathVariable String categoryName){
        return ResponseEntity.ok(productService.findByCategory(categoryName));
    }

    @GetMapping("/categories/{name}")
    public ResponseEntity<Category> getCategoryByName(@PathVariable String name){
        return null; // probably delete this method
    }
    @PostMapping
    public ResponseEntity<ProductResponseDTO> addProduct(@RequestBody ProductDTO dto){
        return ResponseEntity.ok(productService.addProduct(dto));
    }
    @PutMapping
    public ResponseEntity<ProductResponseDTO> updateProduct(@RequestBody ProductDTO dto){
        return ResponseEntity.ok(productService.updateProduct(dto));
    }
    @DeleteMapping
    public ResponseEntity<ProductResponseDTO> deleteProduct(@RequestParam String name){
        return null; //ResponseEntity.ok(productService.deleteProductByName(name))
        //implement deleteProductByName()
    }

    @PostMapping("/categories")
    public ResponseEntity<Category> addCategory(@RequestBody CategoryDTO name){
        return ResponseEntity.ok(categoryService.addNewCategory(name));
    }
    @PutMapping("/categories")
    public ResponseEntity<Category> updateCategory(@RequestBody CategoryDTO dto){
        return ResponseEntity.ok(categoryService.updateExistingCategory(dto));
    }
    @DeleteMapping("/categories/{categoryName}")
    public ResponseEntity<Void> delete(@PathVariable String categoryName){
        categoryService.deleteCategory(categoryName);
        return ResponseEntity.noContent().build();
    }

}
