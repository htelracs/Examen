-- database: ../JHDataBase/JHEcuaFauna.sqlite

/*
Autor: Scarleth Jarrin
Fecha: 16.agosto.2024
Script: Insertar Datos
*/
DELETE FROM JHCatalogoTipo;
INSERT INTO JHCatalogoTipo
 (Nombre)VALUES
 ('Pais'     )
,('Region'   ) 
,('Provincia')
,('GenoAlimento' )
,('IngestaNativa')
,('Sexo'     )
,('Hormiga'  ); 

DELETE FROM JHCatalogo;
INSERT INTO JHCatalogo
 (  IdCatalogoTipo    ,  Nombre        ,  IdCatalogoPadre) VALUES
 (         7          ,  'Ecuador'     ,        NULL     ) 

,(         8          ,  'Costa'       ,         294       )  
,(         8          ,  'Sierra '     ,         294       ) 
,(         8          ,  'Oriente'     ,         294       ) 
,(         8          ,  'Galapagos'   ,         294       ) 
 
,(         9          ,  'Esmeraldas'  ,         295       ) 
,(         9          ,  'Manabi'      ,         295       )
,(         9          ,  'Los Rios'    ,         295       )
,(         9          ,  'Guayas'      ,         295       )
,(         9          ,  'Santa Elena' ,         295       )
,(         9          ,  'El Oro'      ,         295       )
,(         9          ,  'Sto, Domingo de T',    295       )

,(         9          ,  'Carchi'      ,        296        )
,(         9          ,  'Imbabura'    ,        296        )
,(         9          ,  'Pichincha'   ,        296        )
,(         9          ,  'Cotopaxi'    ,        296        )
,(         9          ,  'Tungurahua'  ,        296        )
,(         9          ,  'Bolivar'     ,        296        )
,(         9          ,  'Chimborazo'  ,        296        )
,(         9          ,  'Canar'       ,        296        )
,(         9          ,  'Azuay'       ,        296        )
,(         9          ,  'Loja'        ,        296        )

,(         9          ,  'Sucumbios'        ,      297     )
,(         9          ,  'Napo'             ,      297     )
,(         9          ,  'Orellana'         ,      297     )
,(         9          ,  'Pastaza'          ,      297     )
,(         9          ,  'Morona Santiago'  ,      297     )
,(         9          ,  'Zamora Chinchipe' ,      297     )

,(         9          ,  'Galapagos'        ,       298        )

,(         11          ,  'Carnivoro'        ,       NULL      )
,(         11          ,  'Herviboro'        ,       NULL      )
,(         11          ,  'Omnivoro'         ,       NULL      )
,(         11          ,  'Insectivoro'      ,       NULL      )
,(         11          ,  'Nectarivoro'      ,       NULL      )

,(         10         ,  'X'                ,       NULL      )
,(         10         ,  'XX'               ,       NULL      )
,(         10         ,  'XY'               ,       NULL      )

,(         12         ,  'Macho    '        ,       NULL      )
,(         12         ,  'Hembra'           ,       NULL      )
,(         12         ,  'Asexual'          ,       NULL      )

,(         13         ,  'Larva'            ,       NULL      )
,(         13         ,  'Soldado'          ,       NULL      )
,(         13         ,  'Ratreadora'       ,       NULL      )
,(         13         ,  'Zangano'          ,       NULL      )
,(         13         ,  'Reina'            ,       NULL      );

DELETE FROM JHHormigero;
INSERT INTO JHHormigero
 (TipoHormiga   , IdCatalogoSexo, IdCatalogoProvincia, IdCatalogoGenoAlimento, IdCatalogoIngestaNativa) VALUES
 (     248      ,       247     ,         215        ,             242       ,          241           );

------
Select  IdCatalogo, Nombre
    FROM    JHCatalogo
    WHERE  IdCatalogoTipo = 9;

DELETE FROM JHVistaProvinvia;
create VIEW JHVistaProvinvia AS
SELECT  IdCatalogo, Nombre
FROM    JHCatalogo
WHERE  IdCatalogoTipo = 9;


DELETE FROM JHVistaSexo;
create VIEW JHVistaSexo AS
SELECT  IdCatalogo, Nombre
FROM    JHCatalogo
WHERE  IdCatalogoTipo = 12;



create VIEW JHVistaTipoHormiga AS
SELECT  IdCatalogo, Nombre
FROM    JHCatalogo
WHERE  IdCatalogoTipo = 13;

create VIEW JHVistaSex AS
SELECT  IdCatalogo, Nombre
FROM    JHCatalogo
WHERE  IdCatalogoTipo = 12;

create VIEW JHVistaProvincia AS
SELECT  IdCatalogo, Nombre
FROM    JHCatalogo
WHERE  IdCatalogoTipo = 9;

create VIEW JHVistaGenoAlimento AS
SELECT  IdCatalogo, Nombre
FROM    JHCatalogo
WHERE  IdCatalogoTipo = 10;

create VIEW JHVistaIngestaNativa AS
SELECT  IdCatalogo, Nombre
FROM    JHCatalogo
WHERE  IdCatalogoTipo = 11;


select * from JHVistaProvinvia;
select * from JHVistaSexo;

select * from JHVistaTipoHormiga;
select * from JHVistaSex;
select * from JHVistaProvincia;
select * from JHVistaGenoAlimento;
select * from JHVistaIngestaNativa;
