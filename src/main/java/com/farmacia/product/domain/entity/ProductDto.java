package com.farmacia.product.domain.entity;

public class ProductDto extends Product {

    private String nombreViaAdmin;
    private String nombreLaboratorio;
    private String nombrePresentacion;
    private String nombrePrincipioAct;
    private String nombreUnidadMedida;
    private String nombreProveedor;

    public ProductDto() {
    }

    public ProductDto(double ganancia, String codproducto, String nombre, String reginvima, String fechaCaducidad,
            int stock, int stockmin, int stockmax, double valorcompra, double valorventa, int idviaadmin,
            int idlaboratorio, int idpresentacion, int idprincipioact, int idunidadmedida, String idproveedor,
            String nombreViaAdmin, String nombreLaboratorio, String nombrePresentacion, String nombrePrincipioAct,
            String nombreUnidadMedida, String nombreProveedor) {
        super(ganancia, codproducto, nombre, reginvima, fechaCaducidad, stock, stockmin, stockmax, valorcompra,
                valorventa, idviaadmin, idlaboratorio, idpresentacion, idprincipioact, idunidadmedida, idproveedor);
        this.nombreViaAdmin = nombreViaAdmin;
        this.nombreLaboratorio = nombreLaboratorio;
        this.nombrePresentacion = nombrePresentacion;
        this.nombrePrincipioAct = nombrePrincipioAct;
        this.nombreUnidadMedida = nombreUnidadMedida;
        this.nombreProveedor = nombreProveedor;
    }

    public ProductDto(String nombreViaAdmin, String nombreLaboratorio, String nombrePresentacion,
            String nombrePrincipioAct, String nombreUnidadMedida, String nombreProveedor) {
        this.nombreViaAdmin = nombreViaAdmin;
        this.nombreLaboratorio = nombreLaboratorio;
        this.nombrePresentacion = nombrePresentacion;
        this.nombrePrincipioAct = nombrePrincipioAct;
        this.nombreUnidadMedida = nombreUnidadMedida;
        this.nombreProveedor = nombreProveedor;
    }

    public String getNombreViaAdmin() {
        return this.nombreViaAdmin;
    }

    public void setNombreViaAdmin(String nombreViaAdmin) {
        this.nombreViaAdmin = nombreViaAdmin;
    }

    public String getNombreLaboratorio() {
        return this.nombreLaboratorio;
    }

    public void setNombreLaboratorio(String nombreLaboratorio) {
        this.nombreLaboratorio = nombreLaboratorio;
    }

    public String getNombrePresentacion() {
        return this.nombrePresentacion;
    }

    public void setNombrePresentacion(String nombrePresentacion) {
        this.nombrePresentacion = nombrePresentacion;
    }

    public String getNombrePrincipioAct() {
        return this.nombrePrincipioAct;
    }

    public void setNombrePrincipioAct(String nombrePrincipioAct) {
        this.nombrePrincipioAct = nombrePrincipioAct;
    }

    public String getNombreUnidadMedida() {
        return this.nombreUnidadMedida;
    }

    public void setNombreUnidadMedida(String nombreUnidadMedida) {
        this.nombreUnidadMedida = nombreUnidadMedida;
    }

    public String getNombreProveedor() {
        return this.nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

}
