package com.farmacia.unidad_medida.domain.entity;

public class UnidadMedida {
    private int idunidadmedida;
    private String nombre;

    public UnidadMedida() {
    }

    public UnidadMedida(int idunidadmedida, String nombre) {
        this.idunidadmedida = idunidadmedida;
        this.nombre = nombre;
    }

    public int getIdunidadmedida() {
        return this.idunidadmedida;
    }

    public void setIdunidadmedida(int idunidadmedida) {
        this.idunidadmedida = idunidadmedida;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
