DROP DATABASE IF EXISTS bdProgramacion;
CREATE DATABASE IF NOT EXISTS bdProgramacion;
USE bdProgramacion;
/*
 ________                  _________			   _________
|		 |1    alquila   1|	   	    |1	repara   N|		    |
|Clientes|--------------->|Vehiculos|<------------|Mecanicos|
|________|                |_________|		      |_________|

Un Cliente alquila UN Vehiculo, un Vehiculo es reparado por VARIOS Mecánicos
PKs:
codvehi --> 1 - 99
codcli --> 100 - 999
codmec --> 1000 - *
*/

-- PK: matricula
CREATE TABLE IF NOT EXISTS vehiculo
	(codvehi int auto_increment,
    matricula char(8),
    marca varchar(20),
    modelo varchar(20),
    puertas tinyint,
    automatico boolean,
		constraint pk_vehiculos primary key (codvehi)
	);
    
-- PK: codcli
-- FK: matricula
CREATE TABLE IF NOT EXISTS cliente
	(codcli int auto_increment,
	nomcli varchar(50),
	ape1cli varchar(50),
	ape2cli varchar(50),
	telcli char(9),
    codvehi int,
		constraint pk_clientes primary key (codcli),
        constraint fk_clientes_vehiculos foreign key (codvehi)
			references vehiculos (codvehi)
				on delete cascade on update cascade
	);
    
-- PK : codmec
-- FK : matricula
CREATE TABLE IF NOT EXISTS mecanico
	(codmec int auto_increment,
    nommec varchar(20),
    ape1mec varchar(20),
    ape2mec varchar(20),
    codvehi int,
		constraint pk_mecanicos primary key (codmec),
        constraint fk_vehiculos_mecanicos foreign key (codvehi)
			references vehiculos (codvehi)
				on delete cascade on update cascade
	);
    
    -- set FOREIGN_KEY_CHECKS=0;
    
INSERT INTO vehiculo
VALUES
(1, '9584JBT', 'Renault', '308', 4, false),
(2, '8452KMN', 'Seat', 'Ibiza', 5, true),
(3, '4750BRP', 'Mazda', 'RX3', 2, true);

INSERT INTO cliente
VALUES
(100, 'Gabriel', 'Allende', 'Palacio', '666356987', 1),
(101, 'Javier', 'Parodi', 'Piñero', '654895201', 2),
(102, 'Juan', 'Tineo', 'Gómez', '659014598', 3);

INSERT INTO mecanico
VALUES
(1001, 'Pedro', 'Martínez', 'Gómez', 1),
(1002, 'Jaime', 'Valero', 'Ruiz', 2),
(1003, 'Rodrigo', 'Moyano', 'Vicario', 3);

Select * from cliente
