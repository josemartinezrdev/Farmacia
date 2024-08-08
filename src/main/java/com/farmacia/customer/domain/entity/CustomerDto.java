package com.farmacia.customer.domain.entity;

import java.sql.Date;

public class CustomerDto extends Customer {

    private String nombreTipo;
    private String nombreBarrio;

    public CustomerDto() {
    }

    public CustomerDto(String nombreTipo, String nombreBarrio) {
        this.nombreTipo = nombreTipo;
        this.nombreBarrio = nombreBarrio;
    }

    public CustomerDto(String idcliente, String nombre, String apellido, int edad, String fechaNacimiento,
            Date fechaRegistro, int idtipo, int idbarrio, String nombreTipo, String nombreBarrio) {
        super(idcliente, nombre, apellido, edad, fechaNacimiento, fechaRegistro, idtipo, idbarrio);
        this.nombreTipo = nombreTipo;
        this.nombreBarrio = nombreBarrio;
    }

    public String getNombreTipo() {
        return this.nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public String getNombreBarrio() {
        return this.nombreBarrio;
    }

    public void setNombreBarrio(String nombreBarrio) {
        this.nombreBarrio = nombreBarrio;
    }

}
