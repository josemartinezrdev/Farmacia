-- GENERAL

DROP DATABASE IF EXISTS farmacia;

CREATE DATABASE farmacia;

USE farmacia;

-- P1

CREATE TABLE ciudades(
    idciudad VARCHAR(3),
    nombre VARCHAR(25),

    CONSTRAINT pk_idciudad PRIMARY KEY (idciudad)
);

CREATE TABLE tipos_documentos(
    idtipo INT(3) AUTO_INCREMENT,
    tipo VARCHAR(25),

    CONSTRAINT pk_idtipo PRIMARY KEY (idtipo)
);

CREATE TABLE barrios(
    idbarrio INT(3) AUTO_INCREMENT,
    nombre VARCHAR(25),
    idciudad VARCHAR(3),

    CONSTRAINT pk_idbarrio PRIMARY KEY (idbarrio),
    CONSTRAINT fk_barrios_ciudades FOREIGN KEY (idciudad) REFERENCES ciudades (idciudad)
);

CREATE TABLE clientes(
    idcliente VARCHAR(20),
    nombre VARCHAR(25),
    apellido VARCHAR(25),
    edad INT,
    fechaNacimiento DATE,
    fechaRegistro DATE,
    idtipo INT(3),
    idbarrio INT(3),

    CONSTRAINT pk_idcliente PRIMARY KEY (idcliente),
    CONSTRAINT fk_clientes_tipos_documentos FOREIGN KEY (idtipo) REFERENCES tipos_documentos (idtipo),
    CONSTRAINT fk_clientes_barrios FOREIGN KEY (idbarrio) REFERENCES barrios (idbarrio)
);

-- P2

CREATE TABLE vias_administracion(
    idviaadmin INT(3) AUTO_INCREMENT,
    nombre VARCHAR(25) UNIQUE,

    CONSTRAINT pk_idviaadmin PRIMARY KEY (idviaadmin)
);

CREATE TABLE laboratorios(
    idlaboratorio INT(3) AUTO_INCREMENT,
    nombre VARCHAR(25) UNIQUE,

    CONSTRAINT pk_idlaboratorio PRIMARY KEY (idlaboratorio)
);

CREATE TABLE presentaciones(
    idpresentacion INT(3) AUTO_INCREMENT,
    nombre VARCHAR(25) UNIQUE,

    CONSTRAINT pk_idpresentacion PRIMARY KEY (idpresentacion)
);

CREATE TABLE principios_activos(
    idprincipioact INT(3) AUTO_INCREMENT,
    nombre VARCHAR(25) UNIQUE,

    CONSTRAINT pk_idprincipioact PRIMARY KEY (idprincipioact)
);

CREATE TABLE unidades_medida(
    idunidadmedida INT(3) AUTO_INCREMENT,
    nombre VARCHAR(25) UNIQUE,

    CONSTRAINT pk_idunidadmedida PRIMARY KEY (idunidadmedida)
);

CREATE TABLE proveedores(
    idproveedor VARCHAR(25),
    nombre VARCHAR(25),
    emial VARCHAR(25),
    telefono VARCHAR(25),

    idtipo INT(3),

    CONSTRAINT pk_idproveedor PRIMARY KEY (idproveedor),
    CONSTRAINT fk_proveedores_tipos_documentos FOREIGN KEY (idtipo) REFERENCES tipos_documentos (idtipo)
);

CREATE TABLE productos(
    codproducto VARCHAR(25),
    nombre VARCHAR(25),
    reginvima VARCHAR(25),
    fechaCaducidad DATE,
    stock INT,
    stockmin INT,
    stockmax INT,
    valorcompra DECIMAL(10, 2),
    valorventa DECIMAL(10, 2),

    idviaadmin INT(3),
    idlaboratorio INT(3),
    idpresentacion INT(3),
    idprincipioact INT(3),
    idunidadmedida INT(3),
    idproveedor VARCHAR(25),

    CONSTRAINT pk_codproducto PRIMARY KEY (codproducto),
    CONSTRAINT fk_productos_vias_administracion FOREIGN KEY (idviaadmin) REFERENCES vias_administracion (idviaadmin),
    CONSTRAINT fk_prodcutos_laboratorios FOREIGN KEY (idlaboratorio) REFERENCES laboratorios (idlaboratorio),
    CONSTRAINT fk_productos_presentaciones FOREIGN KEY (idpresentacion) REFERENCES presentaciones (idpresentacion),
    CONSTRAINT fk_productos_principios_activos FOREIGN KEY (idprincipioact) REFERENCES principios_activos (idprincipioact),
    CONSTRAINT fk_productos_unidades_medida FOREIGN KEY (idunidadmedida) REFERENCES unidades_medida (idunidadmedida),
    CONSTRAINT fk_productos_proveedores FOREIGN KEY (idproveedor) REFERENCES proveedores (idproveedor),

    CONSTRAINT unique_key UNIQUE (
        idviaadmin,
        idlaboratorio,
        idpresentacion,
        idprincipioact,
        idunidadmedida,
        idproveedor
    )
);
