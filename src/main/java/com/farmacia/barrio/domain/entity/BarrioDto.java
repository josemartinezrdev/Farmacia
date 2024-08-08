package com.farmacia.barrio.domain.entity;

public class BarrioDto extends Barrio {
    private String nombreCity;

    public BarrioDto() {
    }

    public BarrioDto(String nombreCity) {
        this.nombreCity = nombreCity;
    }

    public BarrioDto(int idbarrio, String nombre, String idciudad, String nombreCity) {
        super(idbarrio, nombre, idciudad);
        this.nombreCity = nombreCity;
    }

    public String getNombreCity() {
        return this.nombreCity;
    }

    public void setNombreCity(String nombreCity) {
        this.nombreCity = nombreCity;
    }
}