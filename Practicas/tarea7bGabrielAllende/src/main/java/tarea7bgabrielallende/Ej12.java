
package tarea7bgabrielallende;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gabriel
 */
public class Ej12 {
    
    /*12.- En un programa Java, procede a leer el fichero XML generado en el ejercicio anterior y muestra el resultado por pantalla. */
    
    public static void main(String[] args) throws FileNotFoundException {
        //Partiendo de que el fichero está en la ruta "./appstxt/aplicacionestxt.txt":
        String rutaFichero = "./appsxml/aplicacionesxml.xml";
        
        String[] tokens;
        String linea;
        
        //Instancio un ArrayList de App.
        ArrayList<App> listaApp = new ArrayList<>();
        
        try (Scanner datosFichero = new Scanner(new FileReader(rutaFichero))) {
            while (datosFichero.hasNextLine()) {

                linea = datosFichero.nextLine();

                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador
                tokens = linea.split(";");
                //Creo una app auxiliar en la que iré asignando los atributos del 
                //array de Strings.
                App aux = new App();
                //En mi ejercicio, no he puesto setter al código identificativo (pues es un atributo final,
                //siendo único para cada objeto creado), por lo que no obtendré el atributo "COD".
                //Aún así, los objetos serán fácilmente identificables por sus nombres; 
                //vienen en ellos incluídos el valor asignado al propio atributo "COD", con el contador de instancias.
                aux.setNombre(tokens[1]);
                aux.setDescripcion(tokens[2]);
                aux.setTamanio(Double.valueOf(tokens[3]));
                aux.setNumDescargas(Integer.valueOf(tokens[4]));
                
                //Añado los objetos a la lista instanciada anteriormente.
                listaApp.add(aux);
            }
        }
        //Imprimimos por pantalla con un forEach.
        listaApp.forEach(System.out::println);
    }
    
}
