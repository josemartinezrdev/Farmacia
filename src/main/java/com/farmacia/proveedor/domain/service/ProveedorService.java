package com.farmacia.proveedor.domain.service;

import java.util.List;

import com.farmacia.proveedor.domain.entity.Proveedor;
import com.farmacia.proveedor.domain.entity.ProveedorDto;

public interface ProveedorService {

    public void addProveedor(Proveedor proveedor);

    public void updateProveedor(Proveedor proveedor);

    public void deleteProveedor(String id);

    public Proveedor findByIdProveedor(String id);

    public List<Proveedor> findAllProveedores();

    // Dto

    public ProveedorDto findByIdProveedorDto(String id);

    public List<ProveedorDto> findAllProveedoresDto();

}
