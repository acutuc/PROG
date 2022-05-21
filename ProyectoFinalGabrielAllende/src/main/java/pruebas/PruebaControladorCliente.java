package pruebas;

import controladores.ControladorCliente;
import entidades.Cliente;

public class PruebaControladorCliente {

	public static void main(String[] args) {
		//Inicializamos un ControladorCliente
		ControladorCliente controladorC = new ControladorCliente();
		//Imprimimos los datos actuales de la entidad Cliente de nuestra BBDD.
		imprimirEntidades(controladorC);
		
		//Creamos un cliente, asignamos todos sus campos MENOS un vehículo (no lo tiene alquilado).
		Cliente c1 = new Cliente();
		c1.setNomcli("Ana");
		c1.setApe1cli("Lisamel");
		c1.setApe2cli("Trozo");
		c1.setTelcli("666555444");
		
		//Añadimos el cliente a la BBDD.
		controladorC.crearCliente(c1);
		
		//Imprimimos la tabla resulstante.
		imprimirEntidades(controladorC);

	}

	// Método que imprime todos los registros que hayan en la tabla Cliente.
	private static void imprimirEntidades(ControladorCliente controladorC) {
		System.out.println("--------------------------Clientes en nuestra BBDD------------------------");
		for (Cliente c : controladorC.findAll()) {
			System.out.println(c);
		}
	}
}
