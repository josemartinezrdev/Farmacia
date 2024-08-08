package com.farmacia.city.domain.entity;

public class City {

    private String idciudad;
    private String nombre;

    public City() {
    }

    public City(String idciudad, String nombre) {
        this.idciudad = idciudad;
        this.nombre = nombre;
    }

    public String getIdciudad() {
        return this.idciudad;
    }

    public void setIdciudad(String idciudad) {
        this.idciudad = idciudad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
