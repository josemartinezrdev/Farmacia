package com.farmacia.proveedor.application;

import java.util.List;

import com.farmacia.proveedor.domain.entity.Proveedor;
import com.farmacia.proveedor.domain.service.ProveedorService;

public class FindAllProveedorUseCase {
    private ProveedorService proveedorService;

    public FindAllProveedorUseCase(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    public List<Proveedor> execute() {
        return proveedorService.findAllProveedores();
    }

}
