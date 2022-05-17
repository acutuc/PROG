DROP DATABASE IF EXISTS bdProgramacion;
CREATE DATABASE IF NOT EXISTS bdProgramacion;
USE bdProgramacion;
/*
 ________                  _________			   _________
|		 |1    alquila   1|	   	    |1	repara   N|		    |
|Clientes|--------------->|Vehiculos|<------------|Mecanicos|
|________|                |_________|		      |_________|

Un Cliente alquila UN Vehiculo, un Vehiculo es reparado por VARIOS Mecánicos

*/
-- PK: codcli
CREATE TABLE IF NOT EXISTS clientes
	(codcli int not null,
	nomcli varchar(50),
	ape1cli varchar(50),
	ape2cli varchar(50),
	telcli char(9),
		constraint pk_clientes primary key (codcli)
	);
 /*   
-- PK: matricula
-- FK: codcli
CREATE TABLE IF NOT EXISTS vehiculos
	(matricula char(8) not null,
    marca varchar(20),
    modelo varchar(20),
    puertas tinyint,
    automatico boolean,
    codcli int not null,
		constraint pk_vehiculos primary key (matricula),
        constraint fk_vehiculos_clientes foreign key (codcli)
			references clientes (codcli)
				on delete cascade on update cascade
	);
    
-- PK : codmec
-- FK : matricula
CREATE TABLE IF NOT EXISTS mecanicos
	(codmec int not null,
    nommec varchar(20),
    ape1mec varchar(20),
    ape2mec varchar(20),
    matricula char(8),
		constraint pk_mecanicos primary key (codmec),
        constraint fk_vehiculos_mecanicos foreign key (matricula)
			references vehiculos (matricula)
				on delete cascade on update cascade
	);
*/
INSERT INTO clientes
VALUES
(1, 'Gabriel', 'Allende', 'Palacio', '666356987'),
(2, 'Javier', 'Parodi', 'Piñero', '654895201'),
(3, 'Juan', 'Tineo', 'Gómez', '659014598');

/*
INSERT INTO vehiculos
VALUES
('9584JBT', 'Renault', '308', 4, false, 1),
('8452KMN', 'Seat', 'Ibiza', 5, true, 2),
('4750BRP', 'Mazda', 'RX3', 2, true, 3);

INSERT INTO mecanicos
VALUES
(1, 'Pedro', 'Martínez', 'Gómez', '9584JBT'),
(2, 'Jaime', 'Valero', 'Ruiz', '8452KMN'),
(3, 'Rodrigo', 'Moyano', 'Vicario', '4750BRP');
*/
Select * from clientes
