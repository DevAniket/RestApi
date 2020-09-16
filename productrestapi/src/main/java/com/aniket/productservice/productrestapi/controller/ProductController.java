package com.aniket.productservice.productrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.*;

import com.aniket.productservice.productrestapi.model.Product;
import com.aniket.productservice.productrestapi.service.ProductService;

@RestController
@Validated
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity < List < Product >> getAllProduct() {
        return ResponseEntity.ok().body(productService.getAllProduct());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity < Product > getProductById(@PathVariable @Min(1) long id) {
        return ResponseEntity.ok().body(productService.getProductById(id));
    }
    
    @GetMapping("/products/byType/{type}")
    public ResponseEntity <List< Product >> getProductByType(@PathVariable String type) {
        return ResponseEntity.ok().body(productService.getProductByProductType(type));
    }

    @PostMapping("/products")
    public ResponseEntity < Product > createProduct(@Valid @RequestBody Product product) {
        return ResponseEntity.ok().body(this.productService.addProduct(product));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity < Product > updateProduct(@PathVariable 
    		@Min(1) long id, @RequestBody Product product) {
        product.setId(id);
        return ResponseEntity.ok().body(this.productService.updateProduct(product));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String>  deleteProduct(@PathVariable @Min(1) long id) {
        this.productService.deleteProduct(id);
        return ResponseEntity.ok().body("Product deleted successfully");
    }
    
}