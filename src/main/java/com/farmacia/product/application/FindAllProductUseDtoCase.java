package com.farmacia.product.application;

import java.util.List;

import com.farmacia.product.domain.entity.ProductDto;
import com.farmacia.product.domain.service.ProductService;

public class FindAllProductUseDtoCase {
    private ProductService productService;

    public FindAllProductUseDtoCase(ProductService productService) {
        this.productService = productService;
    }

    public List<ProductDto> execute() {
        return productService.findAllProductsDto();
    }
}
