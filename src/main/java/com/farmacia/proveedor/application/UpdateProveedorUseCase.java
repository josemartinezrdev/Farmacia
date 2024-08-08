package com.farmacia.proveedor.application;

import com.farmacia.proveedor.domain.entity.Proveedor;
import com.farmacia.proveedor.domain.service.ProveedorService;

public class UpdateProveedorUseCase {
    private ProveedorService proveedorService;

    public UpdateProveedorUseCase(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    public void execute(Proveedor proveedor) {
        proveedorService.updateProveedor(proveedor);
    }
}
