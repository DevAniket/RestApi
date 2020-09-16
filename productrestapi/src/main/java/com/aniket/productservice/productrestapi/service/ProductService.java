package com.aniket.productservice.productrestapi.service;

import java.util.List;

import com.aniket.productservice.productrestapi.model.Product;

public interface ProductService {
	Product addProduct(Product product);

    Product updateProduct(Product product);

    List < Product > getAllProduct();

    Product getProductById(long productId);
    
    List<Product> getProductByProductType(String productType);

    void deleteProduct(long id);
}
