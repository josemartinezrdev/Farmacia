package com.farmacia.proveedor.application;

import com.farmacia.proveedor.domain.entity.Proveedor;
import com.farmacia.proveedor.domain.service.ProveedorService;

public class FindByIdProveedorUseCase {
    private ProveedorService proveedorService;

    public FindByIdProveedorUseCase(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    public Proveedor execute(String id) {
        return proveedorService.findByIdProveedor(id);
    }
}
