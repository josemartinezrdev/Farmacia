package com.farmacia.proveedor.application;

import java.util.List;

import com.farmacia.proveedor.domain.entity.ProveedorDto;
import com.farmacia.proveedor.domain.service.ProveedorService;

public class FindAllProveedorDtoUseCase {
    private ProveedorService proveedorService;

    public FindAllProveedorDtoUseCase(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    public List<ProveedorDto> execute() {
        return proveedorService.findAllProveedoresDto();
    }
}
