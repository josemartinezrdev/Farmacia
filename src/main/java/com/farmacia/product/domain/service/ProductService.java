package com.farmacia.product.domain.service;

import java.util.List;

import com.farmacia.product.domain.entity.Product;
import com.farmacia.product.domain.entity.ProductDto;

public interface ProductService {

    public void addProduct(Product product);

    public void updateProduct(Product product);

    public void deleteProduct(String id);

    public Product findByIdProduct(String id);

    public List<Product> findAllProducts();

    // DTO

    public ProductDto findByIdProductDto(String id);

    public List<ProductDto> findAllProductsDto();

}
