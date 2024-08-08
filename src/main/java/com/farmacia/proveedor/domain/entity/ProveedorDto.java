package com.farmacia.proveedor.domain.entity;

public class ProveedorDto extends Proveedor {
    String nombreTipo;

    public ProveedorDto() {
    }

    public ProveedorDto(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public ProveedorDto(String idproveedor, String nombre, String email, String telefono, int idtipo,
            String nombreTipo) {
        super(idproveedor, nombre, email, telefono, idtipo);
        this.nombreTipo = nombreTipo;
    }

    public String getNombreTipo() {
        return this.nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

}
