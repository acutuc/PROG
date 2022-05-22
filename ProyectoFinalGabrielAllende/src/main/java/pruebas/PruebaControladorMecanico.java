package pruebas;

import controladores.ControladorMecanico;
import entidades.Mecanico;

public class PruebaControladorMecanico {

	public static void main(String[] args) {
		//Inicializamos un ControladorMecanico
				ControladorMecanico controladorM = new ControladorMecanico();
				//Imprimimos los datos actuales de la entidad Mecanico de nuestra BBDD.
				imprimirEntidades(controladorM);
				
				//Creamos un mecanico
				Mecanico m1 = new Mecanico();
				//Al ser auto_increment, no es necesario que asignemos PK al mecánico, Gracias a la 
				//anotación @GeneratedValue en la clase Mecanico.
				m1.setNommec("Desguazador");
				m1.setApe1mec("Voraz");
				m1.setApe2mec("Furioso");
				
				//Añadimos el Mecanico a la BBDD.
				controladorM.crearMecanico(m1);
				
				//Imprimimos la tabla resulstante.
				imprimirEntidades(controladorM);

			}

			// Método que imprime todos los registros que hayan en la tabla Cliente.
			private static void imprimirEntidades(ControladorMecanico controladorM) {
				System.out.println("--------------------------Mecánicos en nuestra BBDD------------------------");
				for (Mecanico m : controladorM.findAll()) {
					System.out.println(m);
				}
			}


	}