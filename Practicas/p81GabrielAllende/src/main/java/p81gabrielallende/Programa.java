package p81gabrielallende;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Programa {

	public static void main(String[] args) {
		
		//Instancio un objeto tipo VehiculoDAO, con sus atributos por defecto.
		VehiculoDAO daoVehiculo = new VehiculoDAO();
		
		//Instancio una lista de VehiculoVO
		List<VehiculoVO> listaVehiculo = new ArrayList<>();
		
		//Añadimos tres VehiculoVO a la lista, con los que haremos las distintas operaciones CRUD.
		listaVehiculo.add(new VehiculoVO(1, "4758KLM", "Renault", "Clio", 5, false));
		listaVehiculo.add(new VehiculoVO(2, "8935BDK", "Ford", "Focus", 5, false));
		listaVehiculo.add(new VehiculoVO(3, "5420LNJ", "Ferrari", "LaFerrari", 2, true));
		
		try {
			
			System.out.println("Nº de vehiculos insertados " + daoVehiculo.insertVehiculo(listaVehiculo)); //El método insertVehiculo devuelve un int.
            System.out.println("-----------------------------------------");
            System.out.println("Comprobamos en una nueva lista que se recogen los datos desde la tabla.");
            List<VehiculoVO> nuevaLista = daoVehiculo.getAll(); //Volcamos los datos en una nueva tabla "nuevaLista".
            //A partir de este punto trabajaremos solamente con la tabla CLONADA.
            System.out.println("-------- Lista con datos recogidos desde la B.D -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
            System.out.println("Vehiculo con primary key 3: ");
            System.out.println(daoVehiculo.findByPk(3));
            System.out.println("-----------------------------------------");
            System.out.println("Se va a borrar el vehiculo con la pk 3");
            System.out.println("Nº vehiculos borrados " + 
            		daoVehiculo.deleteVehiculo(new VehiculoVO(3, "5420LNJ", "Ferrari", "LaFerrari", 2, true)));
            //El método de arriba, borra el vehiculo y devuelve un int con la cantidad de vehiculos eliminados.
            System.out.println("-----------------------------------------");
            nuevaLista = daoVehiculo.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de borrar un vehiculo-------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
            System.out.println("Modificación del vehiculo con pk 2");
            //Modificamos al vehiculo TODOS sus atributos. Lo que pasemos por parámetro serán sus nuevos valores.
            System.out.println("Nº vehiculos modificados " + 
            		daoVehiculo.updateVehiculo(2, new VehiculoVO(2, "4830LMN", "Seat", "Altea", 5, true)));
            System.out.println("-----------------------------------------");
            nuevaLista = daoVehiculo.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de modificar un vehiculo -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
			
		} catch (SQLException sqle) {
			System.out.println("No se ha podido realizar la operación");
			System.out.println(sqle.getMessage());
		}
		System.out.println();
		listaVehiculo.forEach(System.out::println);
	}

}
