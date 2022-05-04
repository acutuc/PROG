
package tarea7bgabrielallende;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Gabriel
 */
public class Ej12 {
    
    /*12.- En un programa Java, procede a leer el fichero XML generado en el ejercicio anterior y muestra el resultado por pantalla. */
    
    public static void main(String[] args) throws FileNotFoundException, JAXBException {
        //Partiendo de que el fichero está en la ruta "./appstxt/aplicacionestxt.txt":
        String rutaFichero = "./appsxml/aplicacionesxml.xml";
        
        // Crea el contexto JAXB 
        JAXBContext contexto = JAXBContext.newInstance(CatalogoApps.class);
        // Crea el objeto Unmarshaller
        Unmarshaller um = contexto.createUnmarshaller();

        // Llama al método de unmarshalling
        CatalogoApps catalogo = (CatalogoApps) um.unmarshal(new File(rutaFichero));

        ArrayList<App> listaApps = catalogo.getListaApp();

        listaApps.forEach(System.out::println);
    }
    
}
