package com.farmacia.product.application;

import com.farmacia.product.domain.entity.ProductDto;
import com.farmacia.product.domain.service.ProductService;

public class FindByIdProductDtoUseCase {
    private ProductService productService;

    public FindByIdProductDtoUseCase(ProductService productService) {
        this.productService = productService;
    }

    public ProductDto execute(String id) {
        return productService.findByIdProductDto(id);
    }
}
