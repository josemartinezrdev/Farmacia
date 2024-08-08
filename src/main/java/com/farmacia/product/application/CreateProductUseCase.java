package com.farmacia.product.application;

import com.farmacia.product.domain.entity.Product;
import com.farmacia.product.domain.service.ProductService;

public class CreateProductUseCase {

    private ProductService productService;

    public CreateProductUseCase(ProductService productService) {
        this.productService = productService;
    }

    public void execute(Product product) {
        productService.addProduct(product);
    }
}
