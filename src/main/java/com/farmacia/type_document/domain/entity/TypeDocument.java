package com.farmacia.type_document.domain.entity;

public class TypeDocument {

    private int idtipo;
    private String tipo;

    public TypeDocument() {
    }

    public TypeDocument(String tipo) {
        this.tipo = tipo;
    }

    public TypeDocument(int idtipo, String tipo) {
        this.idtipo = idtipo;
        this.tipo = tipo;
    }

    public int getIdtipo() {
        return this.idtipo;
    }

    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
