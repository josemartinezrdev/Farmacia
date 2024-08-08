package com.farmacia.product.domain.entity;

public class Product {

    private double ganancia = 0.30;

    private String codproducto;
    private String nombre;
    private String reginvima;
    private String fechaCaducidad;
    private int stock;
    private int stockmin;
    private int stockmax;
    private double valorcompra;
    private double valorventa;

    private int idviaadmin;
    private int idlaboratorio;
    private int idpresentacion;
    private int idprincipioact;
    private int idunidadmedida;
    private String idproveedor;

    public Product() {
    }

    public Product(double ganancia, String codproducto, String nombre, String reginvima, String fechaCaducidad,
            int stock, int stockmin, int stockmax, double valorcompra, double valorventa, int idviaadmin,
            int idlaboratorio, int idpresentacion, int idprincipioact, int idunidadmedida, String idproveedor) {
        this.ganancia = ganancia;
        this.codproducto = codproducto;
        this.nombre = nombre;
        this.reginvima = reginvima;
        this.fechaCaducidad = fechaCaducidad;
        this.stock = stock;
        this.stockmin = stockmin;
        this.stockmax = stockmax;
        this.valorcompra = valorcompra;
        this.valorventa = valorventa;
        this.idviaadmin = idviaadmin;
        this.idlaboratorio = idlaboratorio;
        this.idpresentacion = idpresentacion;
        this.idprincipioact = idprincipioact;
        this.idunidadmedida = idunidadmedida;
        this.idproveedor = idproveedor;
    }

    public double getGanancia() {
        return this.ganancia;
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }

    public String getCodproducto() {
        return this.codproducto;
    }

    public void setCodproducto(String codproducto) {
        this.codproducto = codproducto;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReginvima() {
        return this.reginvima;
    }

    public void setReginvima(String reginvima) {
        this.reginvima = reginvima;
    }

    public String getFechaCaducidad() {
        return this.fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockmin() {
        return this.stockmin;
    }

    public void setStockmin(int stockmin) {
        this.stockmin = stockmin;
    }

    public int getStockmax() {
        return this.stockmax;
    }

    public void setStockmax(int stockmax) {
        this.stockmax = stockmax;
    }

    public double getValorcompra() {
        return this.valorcompra;
    }

    public void setValorcompra(double valorcompra) {
        this.valorcompra = valorcompra;
    }

    public double getValorventa() {
        return this.valorventa;
    }

    public void setValorventa(double valorventa) {
        this.valorventa = valorventa;
    }

    public int getIdviaadmin() {
        return this.idviaadmin;
    }

    public void setIdviaadmin(int idviaadmin) {
        this.idviaadmin = idviaadmin;
    }

    public int getIdlaboratorio() {
        return this.idlaboratorio;
    }

    public void setIdlaboratorio(int idlaboratorio) {
        this.idlaboratorio = idlaboratorio;
    }

    public int getIdpresentacion() {
        return this.idpresentacion;
    }

    public void setIdpresentacion(int idpresentacion) {
        this.idpresentacion = idpresentacion;
    }

    public int getIdprincipioact() {
        return this.idprincipioact;
    }

    public void setIdprincipioact(int idprincipioact) {
        this.idprincipioact = idprincipioact;
    }

    public int getIdunidadmedida() {
        return this.idunidadmedida;
    }

    public void setIdunidadmedida(int idunidadmedida) {
        this.idunidadmedida = idunidadmedida;
    }

    public String getIdproveedor() {
        return this.idproveedor;
    }

    public void setIdproveedor(String idproveedor) {
        this.idproveedor = idproveedor;
    }

}
