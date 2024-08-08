package com.farmacia.proveedor.application;

import com.farmacia.proveedor.domain.entity.ProveedorDto;
import com.farmacia.proveedor.domain.service.ProveedorService;

public class FindByIdProveedorDtoUseCase {

    private ProveedorService proveedorService;

    public FindByIdProveedorDtoUseCase(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    public ProveedorDto execute(String id) {
        return proveedorService.findByIdProveedorDto(id);
    }
}
