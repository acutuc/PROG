package ej7leerficheroej4;

import ej4ficherosvehiculos.Turismo;
import ej4ficherosvehiculos.Vehiculo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Gabriel
 */
public class Ej7Leer {

    /*7.- Realiza un programa que lea los datos del ejercicio 4. Para ello creará una lista de objetos de tipo Vehículo.
    El programa irá almacenando en la lista los objetos leídos desde el archivo de texto “vehículos.txt”.
    Una vez cargados todos los datos en la lista, ordena los vehículos por Marca y muestra el resultado por consola.*/
    public static void main(String[] args) {
        //ArrayList en el que almacenaré todos los objetos de tipo Vehiculo.
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
        Vehiculo aux = new Vehiculo();

        String idFichero = "vehiculos.txt";
        String[] tokens;
        String linea;

        try (Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(":");
                for (String string : tokens) {
                    System.out.print(string + "\t");
                }
                System.out.println();
            }
            Comparator<Vehiculo> criterioMarca = (v1, v2) -> v1.getMarca().compareTo(v2.getMarca());
            Collections.sort(listaVehiculos, criterioMarca);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
