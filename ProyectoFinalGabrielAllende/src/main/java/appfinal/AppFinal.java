package appfinal;

import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import controladores.ControladorCliente;
import controladores.ControladorFabricante;
import controladores.ControladorVehiculo;
import entidades.Cliente;
import entidades.Fabricante;
import entidades.Vehiculo;

public class AppFinal {

	public static void main(String[] args) {

		System.out.println("Modo Admin. ¿Qué desea hacer?");

		// Array para utilizar en el JOptionPane
		String[] arrayOpciones = { "Consultar datos", "Eliminar datos", "Crear datos", "Actualizar datos", "Salir" };

		// Variable auxiliar para salir del bucle.
		boolean aux = true;

		do {

			int opcionesInt = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Elegir", 0, 1, null,
					arrayOpciones, null);
			switch (opcionesInt) {
			// Case CONSULTAR DATOS.
			case 0:

				menuConsultarDatos();

				// Pasamos la variable auxiliar a true para seguir en bucle hasta pulsar SALIR.
				aux = true;
				break;

			// Case ELIMINAR DATOS
			case 1:

				menuBorrarDatos();

				// Pasamos la variable auxiliar a true para seguir en bucle hasta pulsar SALIR.
				aux = true;
				break;

			// Case CREAR DATOS.
			case 2:

				menuCrearDatos();

				// Pasamos la variable auxiliar a true para seguir en bucle hasta pulsar SALIR.
				aux = true;
				break;

			// Case ACTUALIZAR DATOS.
			case 3:

				menuActualizarDatos();

				// Pasamos la variable auxiliar a true para seguir en bucle hasta pulsar SALIR.
				aux = true;
				break;

			// Default, salir del programa.
			default:
				// Salimos del bucle, finalizando el programa.
				aux = false;
				break;
			}
		} while (aux);
	}

	// Método menú de consulta de datos
	public static void menuConsultarDatos() {
		// Instanciamos un controlador de cada tipo.
		ControladorCliente controladorC = new ControladorCliente();
		ControladorVehiculo controladorV = new ControladorVehiculo();
		ControladorFabricante controladorF = new ControladorFabricante();

		// Array para el menú.
		String[] arrayDatos = { "Clientes", "Vehículos", "Fabricantes", "Volver" };

		boolean aux = true;
		do {
			// Menú de datos.
			int controlBucle = JOptionPane.showOptionDialog(null, "¿Qué datos desea consultar?", "Elegir", 0, 1, null,
					arrayDatos, null);
			switch (controlBucle) {

			// Consultar datos de CLIENTES.
			case 0:
				System.out.println("---------CONSULTA DE CLIENTES----------");
				System.out.println(controladorC.findAll());
				break;

			// Consultar datos de VEHICULOS.
			case 1:
				System.out.println("---------CONSULTA DE VEHICULOS----------");
				System.out.println(controladorV.findAll());
				break;

			// Consultar datos de FABRICANTES.
			case 2:
				System.out.println("---------CONSULTA DE FABRICANTES----------");
				System.out.println(controladorF.findAll());
				break;

			// Volver al menú principal.
			default:
				aux = false;
				break;
			}
		} while (aux); // salimos del bucle cuando aux sea false.

	}

	// Método del menú de borrado de datos.
	public static void menuBorrarDatos() {
		// Instanciamos un controlador de cada tipo.
		ControladorCliente controladorC = new ControladorCliente();
		ControladorVehiculo controladorV = new ControladorVehiculo();

		// Inicializo las tres listas para consulta.
		List<Vehiculo> listaVehiculos = controladorV.findAll();
		List<Cliente> listaClientes = controladorC.findAll();

		// Paso a array de Object las listas inicializadas con los controladores.
		Object[] arrayVehiculos = Arrays.copyOf(listaVehiculos.toArray(), listaVehiculos.size(), Object[].class);
		Object[] arrayClientes = Arrays.copyOf(listaClientes.toArray(), listaClientes.size(), Object[].class);

		// Array para el menú.
		String[] arrayDatos = { "Clientes", "Vehículos", "Fabricantes", "Volver" };

		boolean aux = true;
		do {
			try {
				// Menú de datos.
				int controlBucle = JOptionPane.showOptionDialog(null, "¿Qué datos desea eliminar?", "Elegir", 0, 1,
						null, arrayDatos, null);
				switch (controlBucle) {
				// Borrado de CLIENTES.
				case 0:
					// Éste JOptionPane tiene el método .toString implementado, para evitar el
					// ClassCastException.
					String opcion = JOptionPane.showInputDialog(null, "Elija un cliente a borrar: ", "Elegir",
							JOptionPane.QUESTION_MESSAGE, null, arrayClientes, null).toString(); // <---ATENCIÓN.
					// Bucle que recorre la listaClientes, inicializada con el controladorV.
					for (Cliente c : listaClientes) {
						// Condición a cumplir para el borrado:
						// Que el ID de la opción elegida, mediante substring, sea igual al
						// valor en String del código de cliente.
						if (opcion.substring(19, 22).equals(String.valueOf(c.getCodcli()))) {
							// Borramos el cliente de la base de datos
							controladorC.borrarCliente(c);
						}
					}
					System.out.println("--------------DATOS TRAS ELIMINAR EL REGISTRO------------------");
					System.out.println(controladorC.findAll());
					break;
				// Borrado de VEHICULOS
				case 1:
					opcion = JOptionPane.showInputDialog(null, "Elija un vehículo a borrar: ", "Elegir",
							JOptionPane.QUESTION_MESSAGE, null, arrayVehiculos, null).toString(); // <---ATENCIÓN.
					// Bucle que recorre la listaVehiculos, inicializada con el controladorV.
					for (Vehiculo v : listaVehiculos) {
						// Condición a cumplir para el borrado:
						// Que el ID de la opción elegida, mediante substring, sea igual al
						// valor en String del código de vehículo.
						if (opcion.substring(22, 23).equals(String.valueOf(v.getCodvehi()))) {
							// Borramos el vehículo de la base de datos.
							controladorV.borrarVehiculo(v);
						}
					}
					System.out.println("--------------DATOS TRAS ELIMINAR EL REGISTRO------------------");
					System.out.println(controladorV.findAll());
					break;

				// Borrado de FABRICANTES.
				case 2:
					JOptionPane.showMessageDialog(null, "No puede eliminar un fabricante.");
				default:
					aux = false;
					break;
				}
			} catch (NullPointerException npe) {
				// Catch para escapar al darle a cancelar una vez entramos a borrar un objeto.
			}
		} while (aux);
	}

	// Método que incorpora el menú de datos a mostrar por consola.
	public static void menuCrearDatos() {
		// Instanciamos un controlador de cada tipo.
		ControladorCliente controladorC = new ControladorCliente();
		ControladorVehiculo controladorV = new ControladorVehiculo();
		ControladorFabricante controladorF = new ControladorFabricante();

		// Inicializo las tres listas para consulta.
		List<Fabricante> listaFabricantes = controladorF.findAll();
		List<Vehiculo> listaVehiculos = controladorV.findAll();

		// Paso a array de Object las listas inicializadas con los controladores.
		Object[] arrayFabricantes = Arrays.copyOf(listaFabricantes.toArray(), listaFabricantes.size(), Object[].class);
		Object[] arrayVehiculos = Arrays.copyOf(listaVehiculos.toArray(), listaVehiculos.size(), Object[].class);

		// Array para el menú.
		String[] arrayDatos = { "Clientes", "Vehículos", "Fabricantes", "Volver" };

		boolean aux = true;
		// Menú de datos.
		do {
			int opcionesInt = JOptionPane.showOptionDialog(null, "¿Qué datos desea crear?", "Elegir", 0, 1, null,
					arrayDatos, null);
			switch (opcionesInt) {
			// Creación de CLIENTES.
			case 0:
				// Cliente auxiliar en el que almacenaremos los datos.
				Cliente cliaux = new Cliente();

				String nombreCliente = controlNombre();
				String apellido1Cliente = controlApellido1();
				String apellido2Cliente = controlApellido2();
				String telefonoCliente = controlTelefono();
				cliaux.setNomcli(nombreCliente);
				cliaux.setApe1cli(apellido1Cliente);
				cliaux.setApe2cli(apellido2Cliente);
				cliaux.setTelcli(telefonoCliente);

				// Vehículo que tendrá el cliente SI alquilará algún vehículo en su registro.
				Vehiculo vehiculoAlquilado;
				int preguntaVehiculo = JOptionPane.showConfirmDialog(null, "¿Alquilará éste cliente un vehículo?");
				if (preguntaVehiculo == 0) {
					vehiculoAlquilado = (Vehiculo) JOptionPane.showInputDialog(null,
							"Elija un vehículo para el cliente: ", "Elegir", JOptionPane.QUESTION_MESSAGE, null,
							arrayVehiculos, null);

					// Si el vehículo a alquilar seleccionado, no está asignado a ningún cliente,
					// entonces se lo podemos asignar al cliente que estamos creando.
					if (vehiculoAlquilado.getCliente() == null) {
						cliaux.setVehiculo(vehiculoAlquilado);
					}
					// Sino, saldrá un mensaje diciendo que no puede alquilarlo.
					else {
						JOptionPane.showMessageDialog(null, "Éste vehículo está asignado a otro cliente.");
					}
				}
				// Persistimos el cliente.
				controladorC.crearCliente(cliaux);
				break;

			// Creación de VEHICULOS
			case 1:
				// Declaramos variables para la inserción de datos.
				int intTransmision;
				int intAire;

				// Vehiculo auxiliar en el que almacenaremos los datos.
				Vehiculo vehiaux = new Vehiculo();

				// Fabricante auxiliar en el que pondremos el código del fabricante para el
				// vehículo.
				Fabricante fab = new Fabricante();

				// Asignamos valor a las variables.
				int puertas = controlPuertas();
				intTransmision = JOptionPane.showConfirmDialog(null, "¿Es automático éste vehículo?");
				int caballos = controlCV();

				intAire = JOptionPane.showConfirmDialog(null, "¿Tiene aire acondicionado?");
				// Conversión explícita de String a Fabricante:
				fab = (Fabricante) JOptionPane.showInputDialog(null, "¿Cuál es el cód. de fabricante del vehículo?: ",
						"Elegir", JOptionPane.QUESTION_MESSAGE, null, arrayFabricantes, null);

				// Introducimos las variables en el vehiculo.
				vehiaux.setPuertas(puertas);
				vehiaux.setCaballos(caballos);
				vehiaux.setFabricante(fab);

				if (intTransmision == 0) {
					vehiaux.setAutomatico(true);
				} else {
					vehiaux.setAutomatico(false);
				}

				if (intAire == 0) {
					vehiaux.setAireacon(true);
				} else {
					vehiaux.setAireacon(false);
				}

				// Persistimos el vehículo.
				controladorV.crearVehiculo(vehiaux);
				break;

			// Creación de Fabricantes.
			case 2:
				// Fabricante auxiliar en el que almacenaremos los datos.
				Fabricante fabaux = new Fabricante();

				// Asignamos valor a las variables.
				String nombre = controlNombre();
				String pais = controlPais();

				// Introducimos las variables en el fabricante.
				fabaux.setNomfab(nombre);
				fabaux.setPaisfab(pais);

				// Persistimos el fabricante.
				controladorF.crearFabricante(fabaux);
				break;

			// Default, volvemos al menú principal.
			default:
				aux = false;
				break;
			}
		} while (aux);
	}

	public static void menuActualizarDatos() {
		// Instanciamos un controlador de cada tipo.
		ControladorCliente controladorC = new ControladorCliente();
		ControladorVehiculo controladorV = new ControladorVehiculo();
		ControladorFabricante controladorF = new ControladorFabricante();

		// Inicializo las tres listas para consulta.
		List<Fabricante> listaFabricantes = controladorF.findAll();
		List<Vehiculo> listaVehiculos = controladorV.findAll();
		List<Cliente> listaClientes = controladorC.findAll();

		// Paso a array de Object las listas inicializadas con los controladores.
		Object[] arrayFabricantes = Arrays.copyOf(listaFabricantes.toArray(), listaFabricantes.size(), Object[].class);
		Object[] arrayVehiculos = Arrays.copyOf(listaVehiculos.toArray(), listaVehiculos.size(), Object[].class);
		Object[] arrayClientes = Arrays.copyOf(listaClientes.toArray(), listaClientes.size(), Object[].class);

		// Array para el menú.
		String[] arrayDatos = { "Clientes", "Vehículos", "Fabricantes", "Volver" };

		boolean aux = true;

		do {
			// Menú de datos.
			int opcionesInt = JOptionPane.showOptionDialog(null, "¿Qué datos desea modificar?", "Elegir", 0, 1, null,
					arrayDatos, null);
			switch (opcionesInt) {

			// Actualización de datos de CLIENTES.
			case 0:
				// Éste JOptionPane tiene el método .toString implementado, para evitar el
				// ClassCastException.
				String opcion = JOptionPane.showInputDialog(null, "Elija un cliente a modificar: ", "Elegir",
						JOptionPane.QUESTION_MESSAGE, null, arrayClientes, null).toString(); // <---ATENCIÓN.
				// Bucle que recorre la listaCliente, inicializada con el controladorC.
				for (Cliente c : listaClientes) {
					// Condición a cumplir para el borrado:
					// Que el ID de la opción elegida, mediante substring, sea igual al
					// valor en String del código de cliente.
					if (opcion.substring(19, 22).equals(String.valueOf(c.getCodcli()))) {

						// Objeto Vehiculo que utilizaremos para preguntarle al cliente
						// si en caso afirmativo tiene vehículo alquilado.
						Vehiculo vehiculoAlquilado;

						String nombreCliente = controlNombre();
						String apellido1Cliente = controlApellido1();
						String apellido2Cliente = controlApellido2();
						String telefonoCliente = controlTelefono();

						c.setNomcli(nombreCliente);
						c.setApe1cli(apellido1Cliente);
						c.setApe2cli(apellido2Cliente);
						c.setTelcli(telefonoCliente);

						int preguntaVehiculo = JOptionPane.showConfirmDialog(null,
								"¿Alquilará éste cliente un vehículo?");
						if (preguntaVehiculo == 0) {
							vehiculoAlquilado = (Vehiculo) JOptionPane.showInputDialog(null,
									"Elija un vehículo para el cliente: ", "Elegir", JOptionPane.QUESTION_MESSAGE, null,
									arrayVehiculos, null);

							c.setVehiculo(vehiculoAlquilado);
						}
						// Modificamos el cliente
						controladorC.modificarCliente(c);
					}
				}
				System.out.println("--------------DATOS TRAS MODIFICAR EL REGISTRO------------------");
				System.out.println(controladorC.findAll());
				break;
			// Actualización de datos de VEHICULOS
			case 1:
				opcion = JOptionPane.showInputDialog(null, "Elija un vehículo a modificar: ", "Elegir",
						JOptionPane.QUESTION_MESSAGE, null, arrayVehiculos, null).toString(); // <---ATENCIÓN.
				// Bucle que recorre la listaVehiculos, inicializada con el controladorV.
				for (Vehiculo v : listaVehiculos) {
					// Condición a cumplir para el borrado:
					// Que el ID de la opción elegida, mediante substring, sea igual al
					// valor en String del código de vehículo.
					if (opcion.substring(22, 23).equals(String.valueOf(v.getCodvehi()))) {
						// Declaramos variables para la inserción de datos.
						int intTransmision;
						int intAire;

						int caballos = controlCV();
						int puertas = controlPuertas();
						intTransmision = JOptionPane.showConfirmDialog(null, "¿Es automático éste vehículo?");

						intAire = JOptionPane.showConfirmDialog(null, "¿Tiene aire acondicionado?");

						// Introducimos las variables en el vehiculo.
						v.setPuertas(puertas);
						v.setCaballos(caballos);

						if (intTransmision == 0) {
							v.setAutomatico(true);
						} else {
							v.setAutomatico(false);
						}
						if (intAire == 0) {
							v.setAireacon(true);
						} else {
							v.setAireacon(false);
						}
						// Modificamos el vehículo.
						controladorV.modificarVehiculo(v);
					}
				}
				System.out.println("--------------DATOS TRAS MODIFICAR EL REGISTRO------------------");
				System.out.println(controladorV.findAll());
				break;

			// Actualización de datos de Fabricantes.
			case 2:
				opcion = JOptionPane.showInputDialog(null, "Elija un fabricante a modificar: ", "Elegir",
						JOptionPane.QUESTION_MESSAGE, null, arrayFabricantes, null).toString(); // <---ATENCIÓN.
				// Bucle que recorre la listaFabricantes, inicializada con el controladorF.
				for (Fabricante f : listaFabricantes) {
					// Condición a cumplir para el borrado:
					// Que el ID de la opción elegida, mediante substring, sea igual al
					// valor en String del código de fabricante.
					if (opcion.substring(24, 28).equals(String.valueOf(f.getCodfab()))) {
						// Asignamos valor a las variables.
						String nombre = controlNombre();
						String pais = controlPais();

						// Introducimos las variables en el fabricante.
						f.setNomfab(nombre);
						f.setPaisfab(pais);

						// Modificamos el fabricante.
						controladorF.modificarFabricante(f);
					}
				}
				System.out.println("--------------DATOS TRAS MODIFICAR EL REGISTRO------------------");
				System.out.println(controladorF.findAll().toString());
				break;
			default:
				aux = false;
				break;
			}
		} while (aux);
	}

	// Método que controla que el nombre tenga obligatoriamente letras del alfabeto.
	public static String controlNombre() {
		String aux = "";
		boolean control = true;
		do {
			try {
				aux = JOptionPane.showInputDialog("Introduzca el nombre");

				for (int i = 0; i < aux.length(); i++) {
					char caracter = aux.toUpperCase().charAt(i);
					// Conversión explícita de char a int.
					int valorASCII = (int) caracter;
					// Si alguno de los caracteres no es una letra del alfabeto, mayúscula o
					// minúscula
					// se vuelve a solicitar el dato.
					if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90) && valorASCII != 32) {
						JOptionPane.showMessageDialog(null, "Ha introducido un carácter no válido");
						break;
					}
				}
			} catch (NullPointerException npe) {
				JOptionPane.showMessageDialog(null, "No puede aceptar con el campo vacío o cancelar.");
			}
			if (aux.equals("Ha introducido un carácter no válido")) {
				control = true;
			}
			control = false;
		} while (control);
		return aux;
	}

	// Método que controla que el nombre tenga obligatoriamente letras del alfabeto.
	public static String controlPais() {
		String aux = "";
		boolean control = true;
		do {
			try {
				do {
					aux = JOptionPane.showInputDialog("Introduzca el país del fabricante");

					for (int i = 0; i < aux.length(); i++) {
						char caracter = aux.toUpperCase().charAt(i);
						// Conversión explícita de char a int.
						int valorASCII = (int) caracter;
						// Si alguno de los caracteres no es una letra del alfabeto, mayúscula o
						// minúscula
						// se vuelve a solicitar el dato.
						if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90)) {
							JOptionPane.showMessageDialog(null, "Ha introducido un carácter no válido");
							break;
						}
					}
					control = false;
				} while (control);
				control = true;
			} catch (NullPointerException npe) {
				JOptionPane.showMessageDialog(null, "No puede aceptar con el campo vacío o cancelar.");
			}
			control = false;
		} while (control);
		return aux;
	}

	// Método que controla que el nombre tenga obligatoriamente letras del alfabeto.
	public static String controlApellido1() {
		String aux = "";
		boolean control = true;
		do {
			try {
				aux = JOptionPane.showInputDialog("Introduzca el primer apellido");

				for (int i = 0; i < aux.length(); i++) {
					char caracter = aux.toUpperCase().charAt(i);
					// Conversión explícita de char a int.
					int valorASCII = (int) caracter;
					// Si alguno de los caracteres no es una letra del alfabeto, mayúscula o
					// minúscula
					// se vuelve a solicitar el dato.
					if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90)) {
						JOptionPane.showMessageDialog(null, "Ha introducido un carácter no válido");
						break;
					}
				}
			} catch (NullPointerException npe) {
				JOptionPane.showMessageDialog(null, "No puede aceptar con el campo vacío o cancelar.");
			}
			control = false;
		} while (control);
		return aux;
	}

	// Método que controla que el nombre tenga obligatoriamente letras del alfabeto.
	public static String controlApellido2() {
		String aux = "";
		boolean control = true;
		do {
			try {
				aux = JOptionPane.showInputDialog("Introduzca el segundo apellido");

				for (int i = 0; i < aux.length(); i++) {
					char caracter = aux.toUpperCase().charAt(i);
					// Conversión explícita de char a int.
					int valorASCII = (int) caracter;
					// Si alguno de los caracteres no es una letra del alfabeto, mayúscula o
					// minúscula
					// se vuelve a solicitar el dato.
					if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90)) {
						JOptionPane.showMessageDialog(null, "Ha introducido un carácter no válido");
						break;
					}
				}
			} catch (NullPointerException npe) {
				JOptionPane.showMessageDialog(null, "No puede aceptar con el campo vacío o cancelar.");
			}
			control = false;
		} while (control);
		return aux;
	}

	// Método que controla que el número de teléfono sea un entero de 9 dígitos.
	public static String controlTelefono() {
		String aux = "";
		boolean control = true;
		do {
			try {
				do {
					aux = JOptionPane.showInputDialog("Introduzca el teléfono");
					if (aux.length() != 9) {
						JOptionPane.showMessageDialog(null, "El número debe tener 9 dígitos");
					}
				} while (aux.length() != 9);

				control = false;
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "Tiene que que introducir un número entero de 9 dígitos.");
			}
		} while (control);
		return aux;
	}

	// Método que controla que el número de puertas sea un entero menor de 10.
	public static int controlPuertas() {
		String aux = "";
		boolean control = true;
		int i = 0;
		do {
			try {
				do {
					aux = JOptionPane.showInputDialog("Introduzca cantidad de puertas");
					i = Integer.parseInt(aux);
					if (i >= 10) {
						JOptionPane.showMessageDialog(null, "Demasiadas puertas, ¿no?");
					}
				} while (i >= 10);
				control = false;
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "Tiene que que introducir un número entero menor de 10 dígitos.");
			}
			control = false;
		} while (control);
		return i;
	}

	// Método que controla que el número de CV del vehículo sea un entero.
	public static int controlCV() {
		String aux = "";
		boolean control = true;
		int i = 0;
		do {
			try {
				aux = JOptionPane.showInputDialog("Introduzca los caballos del vehículo");
				i = Integer.parseInt(aux);
				control = false;
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "Tiene que que introducir un número entero.");
			}
			control = false;
		} while (control);
		return i;
	}

}