package com.farmacia.laboratory.domain.entity;

public class Laboratory {
    private int idlaboratorio;
    private String nombre;

    public Laboratory() {
    }

    public Laboratory(int idlaboratorio, String nombre) {
        this.idlaboratorio = idlaboratorio;
        this.nombre = nombre;
    }

    public int getIdlaboratorio() {
        return this.idlaboratorio;
    }

    public void setIdlaboratorio(int idlaboratorio) {
        this.idlaboratorio = idlaboratorio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
