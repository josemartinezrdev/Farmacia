package com.farmacia.proveedor.application;

import com.farmacia.proveedor.domain.entity.Proveedor;
import com.farmacia.proveedor.domain.service.ProveedorService;

public class CreateProveedorUseCase {

    private ProveedorService proveedorService;

    public CreateProveedorUseCase(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    public void execute(Proveedor proveedor) {
        proveedorService.addProveedor(proveedor);
    }
}
