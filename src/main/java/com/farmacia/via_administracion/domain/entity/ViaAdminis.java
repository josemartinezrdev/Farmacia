package com.farmacia.via_administracion.domain.entity;

public class ViaAdminis {
    private int idviaadmin;
    private String nombre;

    public ViaAdminis() {
    }

    public ViaAdminis(int idviaadmin, String nombre) {
        this.idviaadmin = idviaadmin;
        this.nombre = nombre;
    }

    public int getIdviaadmin() {
        return this.idviaadmin;
    }

    public void setIdviaadmin(int idviaadmin) {
        this.idviaadmin = idviaadmin;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
