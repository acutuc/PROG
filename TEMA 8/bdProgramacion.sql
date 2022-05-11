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
	nombre varchar(50),
	apellido1 varchar(50),
	apellido2 varchar(50),
	telefono char(9),
		constraint pk_clientes primary key (codcli)
	);
CREATE TABLE IF NOT EXISTS vehiculos
	(matricula char(8),
    marca varchar(20),
    modelo varchar(20),
    puertas tinyint,
    automatico boolean,
		constraint pk_vehiculos primary key (matricula, codcli),
        constraint fk_vehiculos_clientes foreign key (codcli)
			references clientes
				on delete no action on update cascade
	);
    