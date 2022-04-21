package tarea7agabrielallende;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author acutuc
 */
public class Tarea7AGabrielAllende {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //Nombre del fichero        
        String idFichero = "RelPerCen.csv";

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( BufferedReader datosFichero = new BufferedReader(new InputStreamReader(new FileInputStream(idFichero)))) {
            //Imprimo el fichero original.
            while ((linea = datosFichero.readLine()) != null) {
                tokens = linea.split(";");
                for (String token : tokens) {
                    System.out.println(token + "\t");
                }
            }

        }
    }
}
