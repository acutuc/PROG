
package ejercicio1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author acutuc
 */
public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //String con la ubicación del fichero:
        String ubicacionFichero = "cruceros.json";
        
        //Imprimimos la lista de cruceros con el método de clase creado anteriormente.
        for(Crucero c : LecturaJSON.listaCruceros(ubicacionFichero)){
            System.out.println(c);
        }
        
        //Probamos el método (APARTADO E).
        System.out.println("\nIMPRIMIENDO MAP ORDENADO DE CRUCEROS Y DESTINOS:\n");
        System.out.println((LecturaJSON.listaCruceros(ubicacionFichero)));
    }
    
    //Método de clase que a partir de la lista de cruceros, se obtenga una estructura Map ordenada donde se guarde
    //para cada crucero su lista de destinos.
    public static Map<String, ArrayList<String>> mapOrdenado(ArrayList<Crucero> listaObjetos) throws IOException{
    	 //Creo el Map vacío para hacer el return con los datos implementados.
        Map<String, ArrayList<String>> map = new TreeMap<>();
        //Recorro con un bucle for la lista de Registros
        for (Crucero c : LecturaJSON.listaCruceros("cruceros.json")) {
            c.getNombre();
            c.getDestinos();

            //Almaceno en el map la estación y las precipitaciones.
            map.put(c.getNombre(), c.getDestinos());
        }
        return map;
    }
    
}
