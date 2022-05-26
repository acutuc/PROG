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

		// Array para el menú.
		String[] arrayDatos = { "Clientes", "Vehículos", "Fabricantes", "Volver" };

		boolean aux = true;
		// Menú de datos.

		System.out.println("Modo Admin. ¿Qué desea hacer?");

		// Array para utilizar en el JOptionPane
		String[] arrayOpciones = { "Consultar datos", "Eliminar datos", "Crear datos", "Actualizar datos", "Salir" };
		do {
			// Instanciamos un controlador de cada tipo.
			ControladorCliente controladorC = new ControladorCliente();
			ControladorVehiculo controladorV = new ControladorVehiculo();
			ControladorFabricante controladorF = new ControladorFabricante();

			// Inicializo las tres listas para consulta.
			List<Fabricante> listaFabricantes = controladorF.findAll();
			List<Vehiculo> listaVehiculos = controladorV.findAll();
			List<Cliente> listaClientes = controladorC.findAll();

			// Paso a array de Object las listas inicializadas con los controladores.
			Object[] arrayFabricantes = Arrays.copyOf(listaFabricantes.toArray(), listaFabricantes.size(),
					Object[].class);
			Object[] arrayVehiculos = Arrays.copyOf(listaVehiculos.toArray(), listaVehiculos.size(), Object[].class);
			Object[] arrayClientes = Arrays.copyOf(listaClientes.toArray(), listaClientes.size(), Object[].class);

			int opcionesInt = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Elegir", 0, 1, null,
					arrayOpciones, null);
			switch (opcionesInt) {
			// Case CONSULTAR DATOS.
			case 0:

				menuConsultarDatos(controladorV, controladorC, controladorF, arrayClientes, arrayVehiculos, arrayFabricantes);

				// Pasamos la variable auxiliar a true para seguir en bucle hasta pulsar SALIR.
				aux = true;
				break;

			// Case ELIMINAR DATOS
			case 1:

				menuBorrarDatos(arrayClientes, controladorC, listaClientes, arrayVehiculos, listaVehiculos,
						controladorV, arrayDatos);

				// Pasamos la variable auxiliar a true para seguir en bucle hasta pulsar SALIR.
				aux = true;
				break;

			// Case CREAR DATOS.
			case 2:

				menuCrearDatos(arrayVehiculos, controladorC, arrayFabricantes, controladorV, controladorF);

				// Pasamos la variable auxiliar a true para seguir en bucle hasta pulsar SALIR.
				aux = true;
				break;

			// Case ACTUALIZAR DATOS.
			case 3:

				menuActualizarDatos(arrayClientes, listaClientes, arrayVehiculos, controladorC, listaVehiculos, controladorV, arrayFabricantes, listaFabricantes, controladorF);

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
	public static void menuConsultarDatos(ControladorVehiculo controladorV, ControladorCliente controladorC,
			ControladorFabricante controladorF, Object[] arrayClientes, Object[] arrayVehiculos, Object[] arrayFabricantes) {
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
				List<Cliente> copiaListaC = controladorC.findAll();
				copiaListaC.forEach(System.out::println);
				break;

			// Consultar datos de VEHICULOS.
			case 1:
				System.out.println("---------CONSULTA DE VEHICULOS----------");
				List<Vehiculo> copiaListaV = controladorV.findAll();
				copiaListaV.forEach(System.out::println);
				break;

			// Consultar datos de FABRICANTES.
			case 2:
				System.out.println("---------CONSULTA DE FABRICANTES----------");
				List<Fabricante> copiaListaF = controladorF.findAll();
				copiaListaF.forEach(System.out::println);
				break;

			// Volver al menú principal.
			default:
				aux = false;
				break;
			}
		} while (aux); // salimos del bucle cuando aux sea false.

	}

	// Método del menú de borrado de datos.
	public static void menuBorrarDatos(Object[] arrayClientes, ControladorCliente controladorC,
			List<Cliente> listaClientes, Object[] arrayVehiculos, List<Vehiculo> listaVehiculos,
			ControladorVehiculo controladorV, String[] arrayDatos) {

		try {
			// Menú de datos.
			int controlBucle = JOptionPane.showOptionDialog(null, "¿Qué datos desea eliminar?", "Elegir", 0, 1, null,
					arrayDatos, null);
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
					if (opcion.substring(20, 23).equals(String.valueOf(c.getCodcli()))) {
						// Borramos el cliente de la base de datos
						controladorC.borrarCliente(c);
					}
				}
				System.out.println("--------------DATOS TRAS ELIMINAR EL REGISTRO------------------");
				System.out.println(opcion.substring(20, 23));
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
				break;
			}
		} catch (NullPointerException npe) {
			// Catch para escapar al darle a cancelar una vez entramos a borrar un objeto.
		}
	}

	// Método que incorpora el menú de datos a mostrar por consola.
	public static void menuCrearDatos(Object[] arrayVehiculos, ControladorCliente controladorC,
			Object[] arrayFabricantes, ControladorVehiculo controladorV, ControladorFabricante controladorF) {
		// Array para el menú.
		String[] arrayDatos = { "Clientes", "Vehículos", "Fabricantes", "Volver" };

		// Menú de datos.
		int opcionesInt = JOptionPane.showOptionDialog(null, "¿Qué datos desea crear?", "Elegir", 0, 1, null,
				arrayDatos, null);
		switch (opcionesInt) {
		// Creación de CLIENTES.
		case 0:
			creacionCliente(arrayVehiculos, arrayFabricantes, controladorV, controladorC, controladorF);
			break;

		// Creación de VEHICULOS
		case 1:
			creacionVehiculos(arrayFabricantes, controladorV, controladorF);
			break;

		// Creación de Fabricantes.
		case 2:
			creacionFabricante(controladorF);
			break;

		// Default, volvemos al menú principal.
		default:
			break;
		}
	}

	public static void menuActualizarDatos(Object[] arrayClientes, List<Cliente> listaClientes, Object[] arrayVehiculos,
			ControladorCliente controladorC, List<Vehiculo> listaVehiculos, ControladorVehiculo controladorV,
			Object[] arrayFabricantes, List<Fabricante> listaFabricantes, ControladorFabricante controladorF) {
		// Array para el menú.
		String[] arrayDatos = { "Clientes", "Vehículos", "Fabricantes", "Volver" };

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
				if (opcion.substring(20, 23).equals(String.valueOf(c.getCodcli()))) {

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

					int preguntaVehiculo = JOptionPane.showConfirmDialog(null, "¿Alquilará éste cliente un vehículo?");
					if (preguntaVehiculo == 0) {
						// Si el cliente alquila un vehículo, preguntamos si existe en nuestra base de
						// datos.
						int preguntaCocheNuevo = JOptionPane.showConfirmDialog(null, "¿Existe el vehículo en la base de datos?");
						if (preguntaCocheNuevo == 0) {
							do {
								// Si existe el vehiculo, que elija uno de la lista.
								vehiculoAlquilado = (Vehiculo) JOptionPane.showInputDialog(null,
										"Elija un vehículo para el cliente: ", "Elegir", JOptionPane.QUESTION_MESSAGE, null,
										arrayVehiculos, null);

								// Si el vehículo a alquilar seleccionado, no está asignado a ningún cliente,
								// entonces se lo podemos asignar al cliente que estamos creando.
								if (vehiculoAlquilado.getCliente() == null) {
									c.setVehiculo(vehiculoAlquilado);
								}
								// Sino, saldrá un mensaje diciendo que no puede alquilarlo.
								else {
									JOptionPane.showMessageDialog(null, "Éste vehículo está asignado a otro cliente.");
								}
							} while (vehiculoAlquilado != null);
							//Si el vehículo a alquilar, no existe en la base de datos, creamos uno.
						} else {
							creacionVehiculos(arrayFabricantes, controladorV, controladorF);
							List<Vehiculo> copiaLista = controladorV.findAll();
							
							//Asignamos automáticamente al cliente el último coche creado.
							c.setVehiculo(copiaLista.get(copiaLista.size()-1));
						}
						// Si el cliente no alquila ningun vehículo
					}
					// Persistimos el cliente.
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

					// Asignamos valor a las variables.
					int puertas = controlPuertas();
					intTransmision = JOptionPane.showConfirmDialog(null, "¿Es automático éste vehículo?");
					int caballos = controlCV();

					intAire = JOptionPane.showConfirmDialog(null, "¿Tiene aire acondicionado?");
					int fabricante = JOptionPane.showConfirmDialog(null, "¿Existe el fabricante en nuestra base de datos?");
					if (fabricante == 0) {
						// Conversión explícita de String a Fabricante:
						Fabricante fab = (Fabricante) JOptionPane.showInputDialog(null, "¿Cuál es el cód. de fabricante del vehículo?: ",
								"Elegir", JOptionPane.QUESTION_MESSAGE, null, arrayFabricantes, null);
						v.setFabricante(fab);
					} else {
						creacionFabricante(controladorF);
						List<Fabricante> copiaLista = controladorF.findAll();
						
						//Asignamos el último fabricante creado al vehículo.
						v.setFabricante(copiaLista.get(copiaLista.size() - 1));
					}

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

					// Persistimos el vehículo.
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
					String nombre = controlNombreFabricante();
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
			break;
		}
	}

	// Método que controla que el nombre.
	public static String controlNombre() {
		String aux = "";
		do {
			aux = JOptionPane.showInputDialog("Introduzca el nombre");
		} while (aux == null || aux.equals(""));
		return aux;
	}
	
	//Método que controla el nombre del fabricante
	// Método que controla que el nombre tenga obligatoriamente letras del alfabeto.
		public static String controlNombreFabricante() {
			String aux = "";
			do {
				aux = JOptionPane.showInputDialog("Introduzca el nombre del fabricante");
			} while (aux == null || aux.equals(""));
			return aux;
		}

	// Método que controla que el nombre tenga obligatoriamente letras del alfabeto.
	public static String controlPais() {
		String aux = "";
		do {
			aux = JOptionPane.showInputDialog("Introduzca el país del fabricante");
			if (aux == null || aux.equals("")) {
				JOptionPane.showMessageDialog(null, "No puede dejar el campo vacío");
			}
		} while (aux == null || aux.equals(""));
		return aux;
	}

	// Método que controla que el nombre tenga obligatoriamente letras del alfabeto.
	public static String controlApellido1() {
		String aux = "";
		do {
			aux = JOptionPane.showInputDialog("Introduzca el primer apellido");
			if (aux == null || aux.equals("")) {
				JOptionPane.showMessageDialog(null, "No puede dejar el campo vacío");
			}
		} while (aux == null || aux.equals(""));
		return aux;
	}

	// Método que controla que el nombre tenga obligatoriamente letras del alfabeto.
	public static String controlApellido2() {
		String aux = "";
		do {
			aux = JOptionPane.showInputDialog("Introduzca el segundo apellido");
			if (aux == null || aux.equals("")) {
				JOptionPane.showMessageDialog(null, "No puede dejar el campo vacío");
			}
		} while (aux == null || aux.equals(""));
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
				control = true;
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
					control = false;
				} while (i >= 10);
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "Tiene que que introducir un número entero menor de 10 dígitos.");
				control = true;
			}
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
				control = true;
			}
		} while (control);
		return i;
	}

	// Método que crea un vehículo en la base de datos.
	public static void creacionVehiculos(Object[] arrayFabricantes, ControladorVehiculo controladorV,
			ControladorFabricante controladorF) {
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
		int fabricante = JOptionPane.showConfirmDialog(null, "¿Existe el fabricante en nuestra base de datos?");
		if (fabricante == 0) {
			// Conversión explícita de String a Fabricante:
			fab = (Fabricante) JOptionPane.showInputDialog(null, "¿Cuál es el cód. de fabricante del vehículo?: ",
					"Elegir", JOptionPane.QUESTION_MESSAGE, null, arrayFabricantes, null);
			vehiaux.setFabricante(fab);
		} else {
			creacionFabricante(controladorF);
			List<Fabricante> copiaLista = controladorF.findAll();
			
			//Asignamos el último fabricante creado al vehículo.
			vehiaux.setFabricante(copiaLista.get(copiaLista.size() - 1));
		}

		// Introducimos las variables en el vehiculo.
		vehiaux.setPuertas(puertas);
		vehiaux.setCaballos(caballos);

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
	}

	// Método que controla que la transmisión del vehículo no sea null
	public static void controlTransmision() {
		int aux = 0;
		do {
			aux = JOptionPane.showConfirmDialog(null, "¿Es automático éste vehículo?");
			if (aux != 0 || aux != 1) {
				JOptionPane.showMessageDialog(null, "Diga si es automático o no");
			}

		} while (aux != 0 || aux != 1);
	}

	// Método para crear un cliente
	public static void creacionCliente(Object[] arrayVehiculos, Object[] arrayFabricantes,
			ControladorVehiculo controladorV, ControladorCliente controladorC, ControladorFabricante controladorF) {
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
			// Si el cliente alquila un vehículo, preguntamos si existe en nuestra base de
			// datos.
			int preguntaCocheNuevo = JOptionPane.showConfirmDialog(null, "¿Existe el vehículo en la base de datos?");
			if (preguntaCocheNuevo == 0) {
				do {
					// Si existe el vehiculo, que elija uno de la lista.
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
				} while (vehiculoAlquilado != null);
				//Si el vehículo a alquilar, no existe en la base de datos, creamos uno.
			} else {
				creacionVehiculos(arrayFabricantes, controladorV, controladorF);
				List<Vehiculo> copiaLista = controladorV.findAll();
				
				//Asignamos automáticamente al cliente el último coche creado.
				cliaux.setVehiculo(copiaLista.get(copiaLista.size()-1));
			}
			// Si el cliente no alquila ningun vehículo
		}
		// Persistimos el cliente.
		controladorC.crearCliente(cliaux);
	}

	// Método para crear un fabricante
	public static void creacionFabricante(ControladorFabricante controladorF) {
		// Fabricante auxiliar en el que almacenaremos los datos.
		Fabricante fabaux = new Fabricante();

		// Asignamos valor a las variables.
		String nombre = controlNombreFabricante();
		String pais = controlPais();

		// Introducimos las variables en el fabricante.
		fabaux.setNomfab(nombre);
		fabaux.setPaisfab(pais);

		// Persistimos el fabricante.
		controladorF.crearFabricante(fabaux);
	}
}