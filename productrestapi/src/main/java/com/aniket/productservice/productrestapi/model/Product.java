package com.aniket.productservice.productrestapi.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "Product name is a required field")
    @Size(min = 1, max = 20, message = "Product name should be between 1 to 20 characters")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "description is a required field")
    @Size(min = 1, max = 100, message = "description should be between 1 to 100 characters")
    @Column(name = "description")
    private String description;

    @NotEmpty(message = "productType is a required field")
    @Size(min = 1, max = 20, message = "productType should be between 1 to 20 characters")
    @Column(name = "productType")
    private String productType;
    
    @NotNull(message = "price is a required field")
    @Column(name = "price")
    private BigDecimal price;

    @CreationTimestamp
    private Date createdAt;

    @CreationTimestamp
    private Date updatedAt;

    @NotEmpty(message = "productFeatures is a required field")
    @ElementCollection
    @Column(name ="productFeatures")
    private Map<String, String> productFeatures = new HashMap<String, String>();

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	public Map<String, String> getProductFeatures() {
		return productFeatures;
	}
	public void setProductFeatures(Map<String, String> productFeatures) {
		this.productFeatures = productFeatures;
	}
    
    
}
