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
		// Instanciamos un controlador de cada tipo.
		ControladorCliente controladorC = new ControladorCliente();
		ControladorVehiculo controladorV = new ControladorVehiculo();
		ControladorFabricante controladorF = new ControladorFabricante();

		System.out.println("Modo Admin. ¿Qué desea hacer?");

		// Array para utilizar en el JOptionPane
		String[] arrayOpciones = { "Consultar datos", "Eliminar datos", "Crear datos", "Actualizar datos", "Salir" };

		// Variable auxiliar para salir del bucle.
		boolean aux = true;

		// Variable para elegir las opciones dentro del JOption
		String opcion = "";

		// Inicializo las tres listas para consulta.
		List<Fabricante> listaFabricantes = controladorF.findAll();
		List<Vehiculo> listaVehiculos = controladorV.findAll();
		List<Cliente> listaClientes = controladorC.findAll();
		
		
		// Array para el menú.
		String[] arrayDatos = { "Clientes", "Vehículos", "Fabricantes", "Volver" };
		do {
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
				do {
					// Menú de datos.
					opcionesInt = JOptionPane.showOptionDialog(null, "¿Qué datos desea consultar?", "Elegir", 0, 1,
							null, arrayDatos, null);
					switch (opcionesInt) {
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
						// .toString() para que concatene el toStringVehiculos();
						System.out.println(controladorF.findAll().toString());
						break;
					// Volver al menú principal.
					default:
						aux = false;
						break;
					}
				} while (aux); // salimos del bucle cuando aux sea false.

				// Pasamos la variable auxiliar a true para seguir en bucle hasta pulsar SALIR.
				aux = true;
				break;

			// Case ELIMINAR DATOS
			case 1:
				// Menú de datos.
				opcionesInt = JOptionPane.showOptionDialog(null, "¿Qué datos desea eliminar?", "Elegir", 0, 1, null,
						arrayDatos, null);
				switch (opcionesInt) {
				// Borrado de CLIENTES.
				case 0:
					// Éste JOptionPane tiene el método .toString implementado, para evitar el
					// ClassCastException.
					opcion = JOptionPane.showInputDialog(null, "Elija un cliente a borrar: ", "Elegir",
							JOptionPane.QUESTION_MESSAGE, null, arrayClientes, null).toString(); // <---ATENCIÓN.
					// Bucle que recorre la listaClientes, inicializada con el controladorV.
					for (Cliente c : listaClientes) {
						// Condición a cumplir para el borrado:
						// Que el ID de la opción elegida, mediante substring, sea igual al
						// valor en String del código de cliente.
						if (opcion.substring(19, 22).equals(String.valueOf(c.getCodcli()))) {
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
							controladorV.borrarVehiculo(v);
						}
					}
					System.out.println("--------------DATOS TRAS ELIMINAR EL REGISTRO------------------");
					System.out.println(controladorV.findAll());
					break;
					
				// Borrado de FABRICANTES.
				case 2:
					JOptionPane.showMessageDialog(null, "No puede eliminar un fabricante.");
				}
				aux = true;
				break;

			// Case CREAR DATOS.
			case 2:
				// Menú de datos.
				opcionesInt = JOptionPane.showOptionDialog(null, "¿Qué datos desea crear?", "Elegir", 0, 1, null,
						arrayDatos, null);
				switch (opcionesInt) {
				// Creación de CLIENTES.
				case 0:
					// Declaramos variables para la inserción de datos.
					String nombreCliente;
					String apellido1Cliente;
					String apellido2Cliente;
					String telefonoCliente;
					Vehiculo vehiculoAlquilado;
					// Cliente auxiliar en el que almacenaremos los datos.
					Cliente cliaux = new Cliente();

					nombreCliente = JOptionPane.showInputDialog("Introduzca el nombre");
					apellido1Cliente = JOptionPane.showInputDialog("Introduzca el primer apellido");
					apellido2Cliente = JOptionPane.showInputDialog("Introduzca el segundo apellido");
					telefonoCliente = JOptionPane.showInputDialog("Introduzca el teléfono de contacto");

					cliaux.setNomcli(nombreCliente);
					cliaux.setApe1cli(apellido1Cliente);
					cliaux.setApe2cli(apellido2Cliente);
					cliaux.setTelcli(telefonoCliente);

					int preguntaVehiculo = JOptionPane.showConfirmDialog(null, "¿Alquilará éste cliente un vehículo?");
					if (preguntaVehiculo == 0) {
						vehiculoAlquilado = (Vehiculo) JOptionPane.showInputDialog(null,
								"Elija un vehículo para el cliente: ", "Elegir", JOptionPane.QUESTION_MESSAGE, null,
								arrayVehiculos, null);

						cliaux.setVehiculo(vehiculoAlquilado);
					}
					controladorC.crearCliente(cliaux);
					break;

				// Creación de VEHICULOS
				case 1:
					// Declaramos variables para la inserción de datos.
					int intTransmision;
					int puertas;
					int intAire;
					int caballos;
					int codfab;

					// Vehiculo auxiliar en el que almacenaremos los datos.
					Vehiculo vehiaux = new Vehiculo();

					// Fabricante auxiliar en el que pondremos el código del fabricante para el
					// vehículo.
					Fabricante fab = new Fabricante();

					// Asignamos valor a las variables.
					puertas = Integer.parseInt(JOptionPane.showInputDialog("Introduzca cantidad de puertas"));
					intTransmision = JOptionPane.showConfirmDialog(null, "¿Es automático éste vehículo?");
					caballos = Integer.parseInt(JOptionPane.showInputDialog("CV del coche"));

					intAire = JOptionPane.showConfirmDialog(null, "¿Tiene aire acondicionado?");
					codfab = Integer.parseInt(JOptionPane.showInputDialog("Introduzca cantidad de puertas"));
					fab = (Fabricante) JOptionPane.showInputDialog(null,
							"¿Cuál es el cód. de fabricante del vehículo?: ", "Elegir", JOptionPane.QUESTION_MESSAGE,
							null, arrayFabricantes, null);

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

					controladorV.crearVehiculo(vehiaux);
					break;

				// Creación de Fabricantes.
				case 2:
					// Declaramos variables para la inserción de datos.
					String nombre;
					String pais;

					// Fabricante auxiliar en el que almacenaremos los datos.
					Fabricante fabaux = new Fabricante();

					// Asignamos valor a las variables.
					nombre = JOptionPane.showInputDialog("Introduzca el nombre del fabricante");
					pais = JOptionPane.showInputDialog("Introduzca el país del fabricante");

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
				aux = true;
				break;

			// Case ACTUALIZAR DATOS.
			case 3:
				// Menú de datos.
				opcionesInt = JOptionPane.showOptionDialog(null, "¿Qué datos desea modificar?", "Elegir", 0, 1, null,
						arrayDatos, null);
				switch (opcionesInt) {
				// Actualización de datos de CLIENTES.
				case 0:
					// Éste JOptionPane tiene el método .toString implementado, para evitar el
					// ClassCastException.
					opcion = JOptionPane.showInputDialog(null, "Elija un cliente a modificar: ", "Elegir",
							JOptionPane.QUESTION_MESSAGE, null, arrayClientes, null).toString(); // <---ATENCIÓN.
					// Bucle que recorre la listaCliente, inicializada con el controladorC.
					for (Cliente c : listaClientes) {
						// Condición a cumplir para el borrado:
						// Que el ID de la opción elegida, mediante substring, sea igual al
						// valor en String del código de cliente.
						if (opcion.substring(19, 22).equals(String.valueOf(c.getCodcli()))) {
							// Declaramos variables para la inserción de datos.
							String nombreCliente;
							String apellido1Cliente;
							String apellido2Cliente;
							String telefonoCliente;

							// Objeto Vehiculo que utilizaremos para preguntarle al cliente
							// si en caso afirmativo tiene vehículo alquilado.
							Vehiculo vehiculoAlquilado;

							nombreCliente = JOptionPane.showInputDialog("Introduzca el nombre");
							apellido1Cliente = JOptionPane.showInputDialog("Introduzca el primer apellido");
							apellido2Cliente = JOptionPane.showInputDialog("Introduzca el segundo apellido");
							telefonoCliente = JOptionPane.showInputDialog("Introduzca el teléfono de contacto");

							c.setNomcli(nombreCliente);
							c.setApe1cli(apellido1Cliente);
							c.setApe2cli(apellido2Cliente);
							c.setTelcli(telefonoCliente);

							int preguntaVehiculo = JOptionPane.showConfirmDialog(null,
									"¿Alquilará éste cliente un vehículo?");
							if (preguntaVehiculo == 0) {
								vehiculoAlquilado = (Vehiculo) JOptionPane.showInputDialog(null,
										"Elija un vehículo para el cliente: ", "Elegir", JOptionPane.QUESTION_MESSAGE,
										null, arrayVehiculos, null);

								c.setVehiculo(vehiculoAlquilado);
							}
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
							int puertas;
							int intAire;

							// Asignamos valor a las variables.
							puertas = Integer.parseInt(JOptionPane.showInputDialog("Introduzca cantidad de puertas"));
							intTransmision = JOptionPane.showConfirmDialog(null, "¿Es automático éste vehículo?");

							intAire = JOptionPane.showConfirmDialog(null, "Introduzca la marca");

							// Introducimos las variables en el vehiculo.
							v.setPuertas(puertas);

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
							// Declaramos variables para la inserción de datos.
							String nombre;
							String pais;

							// Asignamos valor a las variables.
							nombre = JOptionPane.showInputDialog("Introduzca el nombre del fabricante");
							pais = JOptionPane.showInputDialog("Introduzca el país del fabricante");

							// Introducimos las variables en el fabricante.
							f.setNomfab(nombre);
							f.setPaisfab(pais);

							// Persistimos el fabricante.
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

}