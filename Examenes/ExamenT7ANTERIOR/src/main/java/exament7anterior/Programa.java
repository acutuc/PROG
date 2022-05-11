package exament7anterior;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author Gabriel
 */
public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //Ej.1
        System.out.println("Ejercicio 1");
        String idFichero = "nombresModulos.csv";
        
        TreeMap<String, String> mapeo = LecturaCSV.leerCsv(idFichero);
        mapeo.forEach((clave, valor) -> System.out.println(clave + ": " + valor));
        System.out.println("---------------------------------------------------------------------------");
        
        //Ej.2
        System.out.println("Ejercicio 2");
        String idFichero2 = "calificacionesGrupo.json";
        
        ArrayList<RegistroJSON> lista = LecturaJSON.leerJSON(idFichero2);
        lista.forEach(System.out::println);
        System.out.println("---------------------------------------------------------------------------");
        
        //Ej.3
        
    }
}
