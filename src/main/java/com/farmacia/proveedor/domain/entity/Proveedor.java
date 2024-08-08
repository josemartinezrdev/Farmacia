package com.farmacia.proveedor.domain.entity;

public class Proveedor {
    private String idproveedor;
    private String nombre;
    private String email;
    private String telefono;
    private int idtipo;

    public Proveedor() {
    }

    public Proveedor(String idproveedor, String nombre, String email, String telefono, int idtipo) {
        this.idproveedor = idproveedor;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.idtipo = idtipo;
    }

    public String getIdproveedor() {
        return this.idproveedor;
    }

    public void setIdproveedor(String idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdtipo() {
        return this.idtipo;
    }

    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }

}
