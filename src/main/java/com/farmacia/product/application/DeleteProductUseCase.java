package com.farmacia.product.application;

import com.farmacia.product.domain.service.ProductService;

public class DeleteProductUseCase {
    private ProductService productService;

    public DeleteProductUseCase(ProductService productService) {
        this.productService = productService;
    }

    public void execute(String id) {
        productService.deleteProduct(id);
    }
}
