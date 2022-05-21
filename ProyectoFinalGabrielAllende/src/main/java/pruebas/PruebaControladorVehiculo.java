package pruebas;

import controladores.ControladorVehiculo;
import entidades.Vehiculo;

public class PruebaControladorVehiculo {

	public static void main(String[] args) {
		//Inicializamos un ControladorVehiculo
		ControladorVehiculo controladorV = new ControladorVehiculo();
		//Imprimimos los datos actuales de la entidad Mecanico de nuestra BBDD.
		imprimirEntidades(controladorV);
		
		//Creamos un mecanico
		Vehiculo v1 = new Vehiculo();
		//Al ser auto_increment, no es necesario que asignemos PK al vehículo.
		v1.setAutomatico(true);
		v1.setMarca("Lamborghini");
		v1.setMatricula("5192MJP");
		v1.setModelo("Urus");
		v1.setPuertas(5);
		//Añadimos el Mecanico a la BBDD.
		controladorV.crearVehiculo(v1);
		
		//Imprimimos la tabla resulstante.
		imprimirEntidades(controladorV);

	}

	// Método que imprime todos los registros que hayan en la tabla Cliente.
	private static void imprimirEntidades(ControladorVehiculo controladorV) {
		System.out.println("--------------------------Mecánicos en nuestra BBDD------------------------");
		for (Vehiculo v : controladorV.findAll()) {
			System.out.println(v);
		}
	}
}
