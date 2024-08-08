package com.farmacia.product.application;

import com.farmacia.product.domain.entity.Product;
import com.farmacia.product.domain.service.ProductService;

public class UpdateProductUseCase {
    private ProductService productService;

    public UpdateProductUseCase(ProductService productService) {
        this.productService = productService;
    }

    public void execute(Product product) {
        productService.updateProduct(product);
    }
}
