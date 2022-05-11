package exament7anterior;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Gabriel
 */
public class LecturaCSV {

    //Método que permita la lectura del fichero CSV
    public static TreeMap<String, String> leerCsv(String nombreCSV) {
        TreeMap<String, String> mapOrdenado = new TreeMap<>();

        try (Scanner datosFichero = new Scanner(new File(nombreCSV))) {
            while (datosFichero.hasNextLine()) {
                String linea = datosFichero.nextLine();
                linea = linea.replaceAll(" ", "");
                linea = linea.replaceAll("\"", "");

                String[] datosLinea = linea.split(";");

                mapOrdenado.put(datosLinea[0], datosLinea[1]);

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return mapOrdenado;
    }
}
