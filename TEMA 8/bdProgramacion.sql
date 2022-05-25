DROP DATABASE IF EXISTS bdProgramacion;
CREATE DATABASE IF NOT EXISTS bdProgramacion;
USE bdProgramacion;
/*
 ________                  _________			   __________
|		 |1    alquila   1|	   	    |N Construye 1|		     |
|Clientes|----------------|Vehiculos|-------------|Fabricante|
|________|                |_________|		      |__________|

Un Cliente alquila UN Vehiculo, un Vehiculo es reparado por VARIOS Mecánicos
PKs:
codvehi --> 1 - 99
codcli --> 100 - 999
codmec --> 1000 - *
*/
-- PK: codcli
CREATE TABLE IF NOT EXISTS cliente
	(codcli int auto_increment,
	nomcli varchar(50),
	ape1cli varchar(50),
	ape2cli varchar(50),
	telcli char(9),
    codvehi int,
		constraint pk_clientes primary key (codcli),
        constraint fk_clientes_vehiculos foreign key (codvehi)
			references vehiculo (codvehi)
				on delete set null on update cascade
	);
    
-- PK : codfab
CREATE TABLE IF NOT EXISTS fabricante
	(codfab int auto_increment,
    nomfab varchar(20),
    paisfab varchar(20),
		constraint fabricante primary key (codfab)
	);

-- PK: codvehi
-- FK: codcli
-- FK: codfab
CREATE TABLE IF NOT EXISTS vehiculo
	(codvehi int auto_increment,
    puertas tinyint,
    automatico boolean,
    caballos int,
    aireacon boolean,
    codfab int not null,
		constraint pk_vehiculos primary key (codvehi),
		constraint fk_vehiculos_fabricante foreign key (codfab)
			references fabricante (codfab)
				on delete no action on update cascade
	);
    
    -- set FOREIGN_KEY_CHECKS=0;
    
INSERT INTO cliente
VALUES
(100, 'Gabriel', 'Allende', 'Palacio', '666356987', 1),
(101, 'Javier', 'Parodi', 'Piñero', '654895201', 2),
(102, 'Juan', 'Tineo', 'Gómez', '659014598', null);

INSERT INTO vehiculo
(codvehi, puertas, automatico, caballos, aireacon, codfab)
VALUES
(1, 3, true, 520, true, 1001),
(2, 5, false, 90, false, 1003),
(3, 3, false, 125, true, 1003),
(4, 5, true, 110, true, 1002),
(5, 5, false, 95, true, 1004),
(6, 3, true, 210, true, 1004),
(7, 3, false, 190, true, 1004);
    
INSERT INTO fabricante
(codfab, nomfab, paisfab)
VALUES
(1001, 'McLaren', 'Reino Unido'),
(1002, 'Lamborghini', 'Italia'),
(1003, 'Ferrari', 'Italia'),
(1004, 'Ford', 'Estados Unidos');


Select * from cliente;
SELECT * FROM vehiculo;
SELECT * FROM fabricante;