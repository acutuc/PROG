package p81gabrielallende;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Programa {

	public static void main(String[] args) {
		
		//Instancio un objeto tipo ClienteDAO, con sus atributos por defecto.
		ClienteDAO daoCliente = new ClienteDAO();
		
		//Instancio una lista de ClienteVO
		List<ClienteVO> listaCliente = new ArrayList<>();
		
		//Añadimos tres ClienteDAO a la lista, con los que haremos las distintas operaciones CRUD.
		listaCliente.add(new ClienteVO(4, "Jesús", "Ruiz", "Ramirez", "620546983"));
		listaCliente.add(new ClienteVO(5, "Pedro", "Vidales", "Sepúlveda", "688955633"));
		listaCliente.add(new ClienteVO(6, "Ana", "Palacio", "Maldonado", "629666847"));
		
		try {
			
			System.out.println("Nº de clientes insertados " + daoCliente.insertCliente(listaCliente)); //El método insertCliente devuelve un int.
            System.out.println("-----------------------------------------");
            System.out.println("Comprobamos en una nueva lista que se recogen los datos desde la tabla.");
            List<ClienteVO> nuevaLista = daoCliente.getAll(); //Volcamos los datos en una nueva tabla "nuevaLista".
            //A partir de este punto trabajaremos solamente con la tabla CLONADA.
            System.out.println("-------- Lista con datos recogidos desde la B.D -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
            System.out.println("Cliente con primary key 1: ");
            System.out.println(daoCliente.findByPk(1));
            System.out.println("-----------------------------------------");
            System.out.println("Nº clientes borrados " + 
                    daoCliente.deleteCliente(new ClienteVO(3,"Juan", "Tineo", "Gómez", "659014598")));
            //El método de arriba, borra el cliente y devuelve un int con la cantidad de clientes eliminados.
            System.out.println("-----------------------------------------");
            nuevaLista = daoCliente.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de borrar un cliente-------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
            System.out.println("Modificación del cliente con pk 2");
            //Modificamos al cliente TODOS sus atributos. Lo que pasemos por parámetro serán sus nuevos valores.
            System.out.println("Nº Personas modificadas " + 
                    daoCliente.updateCliente(2, new ClienteVO(7, "Romina", "Allende", "Palacio", "629888544")));
            System.out.println("-----------------------------------------");
            nuevaLista = daoCliente.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de modificar un cliente -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
			
		} catch (SQLException sqle) {
			System.out.println("No se ha podido realizar la operación");
			System.out.println(sqle.getMessage());
		}
		System.out.println();
		listaCliente.forEach(System.out::println);
	}

}
