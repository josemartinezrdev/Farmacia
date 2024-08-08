package com.farmacia.principio_activo.domain.entity;

public class PrincipioActivo {
    private int idprincipioact;
    private String nombre;

    public PrincipioActivo() {
    }

    public PrincipioActivo(int idprincipioact, String nombre) {
        this.idprincipioact = idprincipioact;
        this.nombre = nombre;
    }

    public int getIdprincipioact() {
        return this.idprincipioact;
    }

    public void setIdprincipioact(int idprincipioact) {
        this.idprincipioact = idprincipioact;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
