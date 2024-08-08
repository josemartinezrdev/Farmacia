package com.farmacia.customer.domain.entity;

import java.sql.Date;
import java.time.LocalDate;

public class Customer {

    private String idcliente;
    private String nombre;
    private String apellido;
    private int edad;
    private String fechaNacimiento;
    private Date fechaRegistro;
    private int idtipo;
    private int idbarrio;

    public Customer() {
        this.fechaRegistro = Date.valueOf(LocalDate.now());
    }

    public Customer(String idcliente, String nombre, String apellido, int edad, String fechaNacimiento,
            Date fechaRegistro, int idtipo, int idbarrio) {
        this.idcliente = idcliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = (fechaRegistro != null) ? fechaRegistro : Date.valueOf(LocalDate.now());
        this.idtipo = idtipo;
        this.idbarrio = idbarrio;
    }

    public String getIdcliente() {
        return this.idcliente;
    }

    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdtipo() {
        return this.idtipo;
    }

    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }

    public int getIdbarrio() {
        return this.idbarrio;
    }

    public void setIdbarrio(int idbarrio) {
        this.idbarrio = idbarrio;
    }
}
