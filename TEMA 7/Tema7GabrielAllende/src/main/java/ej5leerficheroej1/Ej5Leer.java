package ej5leerficheroej1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author acutuc
 */
public class Ej5Leer {

    /*5.- Implementa un programa para leer los datos del fichero del ejercicio 1.
    El programa, al finalizar de leer la matriz debe mostrar la suma de todos los valores.*/
    public static void main(String[] args) {
        //Fichero a leer.
        String idFichero = "matriz.txt";
        String[] tokens;
        String linea;
        int suma = 0;

        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero
                tokens = linea.split("\t");
                for (String string : tokens) {
                    System.out.print(string + "\t");
                    suma += Integer.valueOf(string);
                }
                System.out.println();
                
            }
            System.out.println("La de todos los elementos es de " + suma);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
