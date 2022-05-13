CREATE DATABASE IF NOT EXISTS bdProgramacion;
USE bdProgramacion;
/*
 ________                  _________			   _________
|		 |1    alquila   1|	   	    |1	repara   N|		    |
|Clientes|--------------->|Vehiculos|<------------|Mecanicos|
|________|                |_________|		      |_________|

Un Cliente alquila UN Vehiculo, un Vehiculo es reparado por VARIOS Mecánicos

*/
CREATE TABLE IF NOT EXISTS clientes
	(codcli int,
	nomcli varchar(50),
	ape1cli varchar(50),
	ape2cli varchar(50),
	telcli char(9),
		constraint pk_clientes primary key (codcli)
	);
CREATE TABLE IF NOT EXISTS vehiculos
	(matricula char(8),
    codcli int,
    marca varchar(20),
    modelo varchar(20),
    puertas tinyint,
    automatico boolean,
		constraint pk_vehiculos primary key (matricula, codcli),
        constraint fk_vehiculos_clientes foreign key (codcli)
			references clientes
				on delete no action on update cascade
	);
    
CREATE TABLE IF NOT EXISTS mecanicos
	(codmec int,
    matricula char(8),
    nommec varchar(20),
    ape1mec varchar(20),
    ape2mec varchar(20),
		constraint pk_mecanicos primary key (codmec, matricula),
        constraint fk_vehiculos_mecanicos foreign key (matricula)
			references vehiculos
				on delete no action on update cascade
	);