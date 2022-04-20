package ej6leerficheroej3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author acutuc
 */
public class Ej6Leer {

    /*6.- Implementa un programa que lea el fichero del ejercicio 3 y muestre el contenido del fichero.
    Además buscará la primera ocurrencia, en cada línea, de las letras seguidas ‘w’, ‘e’, ‘b’, informando de la posición que ocupan en la línea,
    si es que existe esa ocurrencia.*/
    public static void main(String[] args) {
        String idFichero = "ej3.txt";
        String linea;
        String[] tokens;
        
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero
                tokens = linea.split(";");
                for (String string : tokens) {
                    System.out.print(string + ";");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}