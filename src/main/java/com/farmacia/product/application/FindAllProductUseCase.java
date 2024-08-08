package com.farmacia.product.application;

import java.util.List;

import com.farmacia.product.domain.entity.Product;
import com.farmacia.product.domain.service.ProductService;

public class FindAllProductUseCase {
    private ProductService productService;

    public FindAllProductUseCase(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> execute() {
        return productService.findAllProducts();
    }
}
