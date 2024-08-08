package com.farmacia.presentation.domain.entity;

public class Presentation {

    private int idpresentacion;
    private String nombre;

    public Presentation() {
    }

    public Presentation(int idpresentacion, String nombre) {
        this.idpresentacion = idpresentacion;
        this.nombre = nombre;
    }

    public int getIdpresentacion() {
        return this.idpresentacion;
    }

    public void setIdpresentacion(int idpresentacion) {
        this.idpresentacion = idpresentacion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
