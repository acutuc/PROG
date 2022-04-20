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

        try (Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero
                tokens = linea.split(";");
                //Bucle en el que itero en todas las posiciones del array y voy imprimiendo.
                for (String token : tokens) {
                    System.out.print(token + ";");
                }
                System.out.println();
                //Bucle en el que itero en todas las possiciones del array y compruebo si se cumple la
                //ocurrencia descrita en el título del ejercicio.
                for (int i = 0; i < tokens.length; i++) {
                    if (tokens[i].equals("w") && tokens[i + 1].equals("e") && tokens[i + 2].equals("b")) {
                        System.out.println("----------------------------------------------------------------------------------------------------------------------------"
                                + "\n \'w\' encontrada en la posición " + i + ", \'e\' encontrada en la posición " + (i + 1)
                                + ", \'b\' encontrada en la posición " + (i + 2) + 
                                "\n----------------------------------------------------------------------------------------------------------------------------");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
