package appfinal;

import java.util.Arrays;
import java.util.List;

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

			// Paso a array de Object las listas inicializadas con los controladores.
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
				} while (aux); //salimos del bucle cuando aux sea false.
				
				// Pasamos la variable auxiliar a true para seguir en bucle hasta pulsar SALIR.
				aux = true;
				break;
				
			// Case ELIMINAR DATOS
			case 1:
				// Menú de datos.
				opcionesInt = JOptionPane.showOptionDialog(null, "¿Qué datos desea eliminar?", "Elegir", 0, 1, null, arrayDatos, null);
				switch (opcionesInt) {
				// Borrado de CLIENTES.
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
				// Borrado de VEHICULOS
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
				// Borrado de MECANICOS.
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
					String marca;
					String modelo;
					String matricula;
					int puertas;

					// Vehiculo auxiliar en el que almacenaremos los datos.
					Vehiculo vehiaux = new Vehiculo();

					// Asignamos valor a las variables.
					marca = JOptionPane.showInputDialog("Introduzca la marca");
					modelo = JOptionPane.showInputDialog("Introduzca el modelo");
					matricula = JOptionPane.showInputDialog("Introduzca la matricula");
					puertas = Integer.parseInt(JOptionPane.showInputDialog("Introduzca cantidad de puertas"));
					intTransmision = JOptionPane.showConfirmDialog(null, "¿Es automático éste vehículo?");

					// Introducimos las variables en el vehiculo.
					vehiaux.setMarca(marca);
					vehiaux.setModelo(modelo);
					vehiaux.setMatricula(matricula);
					vehiaux.setPuertas(puertas);

					if (intTransmision == 0) {
						vehiaux.setAutomatico(true);
					} else {
						vehiaux.setAutomatico(false);
					}

					controladorV.crearVehiculo(vehiaux);
					break;

				// Creación de MECANICOS.
				case 2:
					// Declaramos variables para la inserción de datos.
					String nombre;
					String apellido1Mecanico;
					String apellido2Mecanico;

					// Mecanico auxiliar en el que almacenaremos los datos.
					Mecanico mecaux = new Mecanico();

					// Asignamos valor a las variables.
					nombre = JOptionPane.showInputDialog("Introduzca el nombre");
					apellido1Mecanico = JOptionPane.showInputDialog("Introduzca el primer apellido");
					apellido2Mecanico = JOptionPane.showInputDialog("Introduzca el segundo apellido");

					// Introducimos las variables en el mecánico.
					mecaux.setNommec(nombre);
					mecaux.setApe1mec(apellido1Mecanico);
					mecaux.setApe2mec(apellido2Mecanico);

					Vehiculo vehiculoReparado;
					preguntaVehiculo = JOptionPane.showConfirmDialog(null,
							"¿Está éste mecánico reparando algún vehículo?");
					if (preguntaVehiculo == 0) {
						vehiculoReparado = (Vehiculo) JOptionPane.showInputDialog(null,
								"Elija el vehículo que esté reparando el mecánico: ", "Elegir",
								JOptionPane.QUESTION_MESSAGE, null, arrayVehiculos, null);

						mecaux.setVehiculo(vehiculoReparado);
					}

					// Creamos el mecánico.
					controladorM.crearMecanico(mecaux);
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
						if (opcion.substring(14, 17).equals(String.valueOf(c.getCodcli()))) {
							String nombreCliente;
							String apellido1Cliente;
							String apellido2Cliente;
							String telefonoCliente;
							Vehiculo vehiculoAlquilado;

							nombreCliente = JOptionPane.showInputDialog("Introduzca el nombre");
							apellido1Cliente = JOptionPane.showInputDialog("Introduzca el primer apellido");
							apellido2Cliente = JOptionPane.showInputDialog("Introduzca el segundo apellido");
							telefonoCliente = JOptionPane.showInputDialog("Introduzca el teléfono de contacto");

							c.setNomcli(nombreCliente);
							c.setApe1cli(apellido1Cliente);
							c.setApe2cli(apellido2Cliente);
							c.setTelcli(telefonoCliente);

							int preguntaVehiculo = JOptionPane.showConfirmDialog(null, "¿Tiene éste cliente algún vehículo alquilado?");
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
					// Bucle que recorre la listaMecanicos, inicializada con el controladorC.
					for (Vehiculo v : listaVehiculos) {
						// Condición a cumplir para el borrado:
						// Que el ID de la opción elegida, mediante substring, sea igual al
						// valor en String del código de vehículo.
						if (opcion.substring(15, 16).equals(String.valueOf(v.getCodvehi()))) {
							int intTransmision;
							String marca;
							String modelo;
							String matricula;
							int puertas;

							// Asignamos valor a las variables.
							marca = JOptionPane.showInputDialog("Introduzca la marca");
							modelo = JOptionPane.showInputDialog("Introduzca el modelo");
							matricula = JOptionPane.showInputDialog("Introduzca la matricula");
							puertas = Integer.parseInt(JOptionPane.showInputDialog("Introduzca cantidad de puertas"));
							intTransmision = JOptionPane.showConfirmDialog(null, "¿Es automático éste vehículo?");
							v.setMarca(marca);
							v.setModelo(modelo);
							v.setMatricula(matricula);
							v.setPuertas(puertas);
							if (intTransmision == 0) {
								v.setAutomatico(true);
							} else {
								v.setAutomatico(false);
							}
							controladorV.modificarVehiculo(v);
						}
					}
					System.out.println("--------------DATOS TRAS MODIFICAR EL REGISTRO------------------");
					System.out.println(controladorV.findAll());
					break;
				// Actualización de dats de MECANICOS.
				case 2:
					opcion = JOptionPane.showInputDialog(null, "Elija un mecánico a modificar: ", "Elegir",
							JOptionPane.QUESTION_MESSAGE, null, arrayMecanicos, null).toString(); // <---ATENCIÓN.
					// Bucle que recorre la listaClientes, inicializada con el controladorM.
					for (Mecanico m : listaMecanicos) {
						// Condición a cumplir para el borrado:
						// Que el ID de la opción elegida, mediante substring, sea igual al
						// valor en String del código de cliente.
						if (opcion.substring(15, 19).equals(String.valueOf(m.getCodmec()))) {
							// Declaramos variables para la inserción de datos.
							String nombre;
							String apellido1Mecanico;
							String apellido2Mecanico;
							Vehiculo vehiculoReparado;

							// Asignamos valor a las variables.
							nombre = JOptionPane.showInputDialog("Introduzca el nombre");
							apellido1Mecanico = JOptionPane.showInputDialog("Introduzca el primer apellido");
							apellido2Mecanico = JOptionPane.showInputDialog("Introduzca el segundo apellido");

							m.setNommec(nombre);
							m.setApe1mec(apellido1Mecanico);
							m.setApe2mec(apellido2Mecanico);

							int preguntaVehiculo = JOptionPane.showConfirmDialog(null,
									"¿Está éste mecánico reparando algún vehículo?");
							if (preguntaVehiculo == 0) {
								vehiculoReparado = (Vehiculo) JOptionPane.showInputDialog(null,
										"Elija el vehículo que esté reparando el mecánico: ", "Elegir",
										JOptionPane.QUESTION_MESSAGE, null, arrayVehiculos, null);

								m.setVehiculo(vehiculoReparado);
							}

							controladorM.modificarMecanico(m);
						}
					}
					System.out.println("--------------DATOS TRAS MODIFICAR EL REGISTRO------------------");
					System.out.println(controladorM.findAll());
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
