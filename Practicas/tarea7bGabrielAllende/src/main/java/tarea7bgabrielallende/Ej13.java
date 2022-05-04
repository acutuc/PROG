package tarea7bgabrielallende;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gabriel
 */
public class Ej13 {

    /*13.- En un programa Java, procede a leer el fichero JSON generado en el ejercicio 11 y muestra el resultado por pantalla.*/
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //Partiendo de que el fichero está en la ruta "./appstxt/aplicacionestxt.txt":
        String rutaFichero = "./appsjson/aplicacionesxml.json";

        ObjectMapper mapeador = new ObjectMapper();
        mapeador.registerModule(new JavaTimeModule());

        ArrayList<App> catalogo = mapeador.readValue(new File(rutaFichero),
                mapeador.getTypeFactory().constructCollectionType(ArrayList.class, App.class));
        System.out.println("---- Catálogo de Apps ----");
        for (App aux : catalogo) {
            System.out.println(aux);
        }

    }
}
