package com.aniket.productservice.productrestapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aniket.productservice.productrestapi.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query("Select p from Product p where p.productType = :type")
	List < Product > getProductByProductType(@Param("type") String productType);
}