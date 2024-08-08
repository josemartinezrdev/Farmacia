package com.farmacia.product.application;

import com.farmacia.product.domain.entity.Product;
import com.farmacia.product.domain.service.ProductService;

public class FindByIdProductUseCase {
    private ProductService productService;

    public FindByIdProductUseCase(ProductService productService) {
        this.productService = productService;
    }

    public Product execute(String id) {
        return productService.findByIdProduct(id);
    }

}
