package appfinal;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import controladores.ControladorCliente;
import controladores.ControladorMecanico;
import controladores.ControladorVehiculo;
import entidades.Cliente;
import entidades.Mecanico;
import entidades.Vehiculo;

public class AppFinal {

	public static void main(String[] args) {
		// Instanciamos un controlador de cada tipo.
		ControladorCliente controladorC = new ControladorCliente();
		ControladorVehiculo controladorV = new ControladorVehiculo();
		ControladorMecanico controladorM = new ControladorMecanico();

		Scanner entrada = new Scanner(System.in);

		System.out.println("Modo Admin. ¿Qué desea hacer?");

		// Array para utilizar en el JOptionPane
		String[] arrayOpciones = { "Consultar datos", "Eliminar datos", "Crear datos", "Actualizar datos", "Salir" };

		// Variable auxiliar para salir del bucle.
		boolean aux = true;

		// Variable para elegir las opciones dentro del JOption
		String opcion = "";

		// Array para el menú.
		String[] arrayDatos = { "Clientes", "Vehículos", "Mecánicos", "Volver" };
		do {
			// Inicializo los 3 controladores para consulta.
			List<Cliente> listaClientes = controladorC.findAll();
			List<Vehiculo> listaVehiculos = controladorV.findAll();
			List<Mecanico> listaMecanicos = controladorM.findAll();

			// Paso a array las listas de objetos, haciendo casting explícito a Object.
			Object[] arrayClientes = Arrays.copyOf(listaClientes.toArray(), listaClientes.size(), Object[].class);
			Object[] arrayVehiculos = Arrays.copyOf(listaVehiculos.toArray(), listaVehiculos.size(), Object[].class);
			Object[] arrayMecanicos = Arrays.copyOf(listaMecanicos.toArray(), listaMecanicos.size(), Object[].class);

			int opcionesInt = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Elegir", 0, 1, null,
					arrayOpciones, null);
			switch (opcionesInt) {
			// Case CONSULTAR DATOS.
			case 0:
				do {
					// Menú de datos.
					opcionesInt = JOptionPane.showOptionDialog(null, "¿Qué datos desea consultar?", "Elegir", 0, 1,
							null, arrayDatos, null);
					switch (opcionesInt) {
					// Consultar datos de CLIENTES
					case 0:
						System.out.println("---------CONSULTA DE CLIENTES----------");
						System.out.println(controladorC.findAll());
						break;
					// Consultar datos de VEHICULOS
					case 1:
						System.out.println("---------CONSULTA DE VEHICULOS----------");
						System.out.println(controladorV.findAll());
						break;
					// Consultar datos de MECANICOS.
					case 2:
						System.out.println("---------CONSULTA DE MECANICOS----------");
						System.out.println(controladorM.findAll());
						break;
					// Volver al menú principal.
					default:
						aux = false;
						break;
					}
				} while (aux);
				// Pasamos la variable auxiliar a true para seguir en bucle hasta pulsar SALIR.
				aux = true;
				break;
			// Case ELIMINAR DATOS
			case 1:
				// Menú de datos.
				opcionesInt = JOptionPane.showOptionDialog(null, "¿Qué datos desea eliminar?", "Elegir", 0, 1, null,
						arrayDatos, null);
				switch (opcionesInt) {
				//Borrado de CLIENTES.
				case 0:
					// Éste JOptionPane tiene el método .toString implementado, para evitar el
					// ClassCastException.
					opcion = JOptionPane.showInputDialog(null, "Elija un cliente a borrar: ", "Elegir",
							JOptionPane.QUESTION_MESSAGE, null, arrayClientes, null).toString(); // <---ATENCIÓN.
					// Bucle que recorre la listaVehiculos, inicializada con el controladorV.
					for (Cliente c : listaClientes) {
						// Condición a cumplir para el borrado:
						// Que el ID de la opción elegida, mediante substring, sea igual al
						// valor en String del código de cliente.
						if (opcion.substring(14, 17).equals(String.valueOf(c.getCodcli()))) {
							controladorC.borrarCliente(c);
						}
					}
					System.out.println("--------------DATOS TRAS ELIMINAR EL REGISTRO------------------");
					System.out.println(controladorC.findAll());
					break;
					//Borrado de VEHICULOS
				case 1:
					opcion = JOptionPane.showInputDialog(null, "Elija un vehículo a borrar: ", "Elegir",
							JOptionPane.QUESTION_MESSAGE, null, arrayVehiculos, null).toString(); // <---ATENCIÓN.
					// Bucle que recorre la listaMecanicos, inicializada con el controladorC.
					for (Vehiculo v : listaVehiculos) {
						// Condición a cumplir para el borrado:
						// Que el ID de la opción elegida, mediante substring, sea igual al
						// valor en String del código de vehículo.
						if (opcion.substring(15, 16).equals(String.valueOf(v.getCodvehi()))) {
							controladorV.borrarVehiculo(v);
						}
					}
					System.out.println("--------------DATOS TRAS ELIMINAR EL REGISTRO------------------");
					System.out.println(controladorV.findAll());
					break;
					//Borrado de MECANICOS.
				case 2:
					opcion = JOptionPane.showInputDialog(null, "Elija un mecánico a borrar: ", "Elegir",
							JOptionPane.QUESTION_MESSAGE, null, arrayMecanicos, null).toString(); // <---ATENCIÓN.
					// Bucle que recorre la listaClientes, inicializada con el controladorM.
					for (Mecanico m : listaMecanicos) {
						// Condición a cumplir para el borrado:
						// Que el ID de la opción elegida, mediante substring, sea igual al
						// valor en String del código de cliente.
						if (opcion.substring(15, 19).equals(String.valueOf(m.getCodmec()))) {
							controladorM.borrarMecanico(m);
						}
					}
					System.out.println("--------------DATOS TRAS ELIMINAR EL REGISTRO------------------");
					System.out.println(controladorM.findAll());
					break;
				default:
					aux = false;
					break;
				}
			case 2:

				break;
			case 3:

				break;
			default:
				// Salimos del bucle, finalizando el programa.
				aux = false;
				break;
			}
		} while (aux);

	}

}
