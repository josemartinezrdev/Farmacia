package com.farmacia.barrio.domain.entity;

public class Barrio {

    private int idbarrio;
    private String nombre;
    private String idciudad;

    public Barrio() {
    }

    public Barrio(int idbarrio, String nombre, String idciudad) {
        this.idbarrio = idbarrio;
        this.nombre = nombre;
        this.idciudad = idciudad;
    }

    public int getIdbarrio() {
        return this.idbarrio;
    }

    public void setIdbarrio(int idbarrio) {
        this.idbarrio = idbarrio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdciudad() {
        return this.idciudad;
    }

    public void setIdciudad(String idciudad) {
        this.idciudad = idciudad;
    }

}
