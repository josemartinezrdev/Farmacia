package com.farmacia.proveedor.application;

import com.farmacia.proveedor.domain.service.ProveedorService;

public class DeleteProveedorUseCase {
    private ProveedorService proveedorService;

    public DeleteProveedorUseCase(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    public void execute(String id) {
        proveedorService.deleteProveedor(id);
    }
}
