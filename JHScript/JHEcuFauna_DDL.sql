-- database: ../JHDataBase/JHEcuaFauna.sqlite

/*
Autor: Scarleth Jarrin
Fecha: 16.agosto.2024
Script: Creacion de la estructura de datos para EcuaFauna 2k24A
*/

DROP TABLE IF EXISTS JHHormigero;
DROP TABLE IF EXISTS JHCatalogo;
DROP TABLE IF EXISTS JHCatalogoTipo;


CREATE TABLE JHCatalogoTipo (
     IdCatalogoTipo      INTEGER        NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Nombre              VARCHAR(15)    NOT NULL UNIQUE
    ,Estado              VARCHAR(1)     NOT NULL DEFAULT('A')
     ,FechaCreacion      DATETIME       DEFAULT(datetime('now','localtime'))
    ,FechaModifica       DATETIME
);

CREATE TABLE JHCatalogo (
     IdCatalogo         INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdCatalogoTipo     INTEGER     NOT NULL REFERENCES JHCatalogoTipo (IdCatalogoTipo)
    ,Nombre             VARCHAR(20) NOT NULL 
    ,IdCatalogoPadre    INTEGER     REFERENCES JHCatalogo(IdCatalogo)
    ,Estado             VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion      DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica      DATETIME
);

CREATE TABLE JHHormigero (
     IdHormiga                  INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,TipoHormiga                INTEGER     NOT NULL REFERENCES JHCatalogo(IdCatalogo)
    ,IdCatalogoSexo             INTEGER     NOT NULL REFERENCES JHCatalogo(IdCatalogo)
    ,IdCatalogoProvincia        INTEGER     NOT NULL REFERENCES JHCatalogo(IdCatalogo)
    ,IdCatalogoGenoAlimento     INTEGER     NOT NULL REFERENCES JHCatalogo(IdCatalogo)
    ,IdCatalogoIngestaNativa    INTEGER     NOT NULL REFERENCES JHCatalogo(IdCatalogo)
    ,Estado                     VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion              DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica              DATETIME
);
