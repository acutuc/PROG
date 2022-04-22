package ej7leerficheroej4;

import ej4ficherosvehiculos.Deportivo;
import ej4ficherosvehiculos.Furgoneta;
import ej4ficherosvehiculos.Turismo;
import ej4ficherosvehiculos.Vehiculo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //ArrayList en el que almacenaré todos los objetos de tipo Vehiculo.
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
        Vehiculo aux = new Vehiculo();

        String idFichero = "vehiculos.txt";
        String[] tokens;
        String linea;
        FileReader fr = new FileReader(idFichero);

        //try-with-resources para leer el fichero "RelPerCen.csv".
        try (Scanner datosFichero = new Scanner(new File(idFichero), "ISO-8859-1")) {
            //Omito la primera línea (encabezado de atributos en el CSV)
            datosFichero.nextLine();
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                //Con el valor '1', suprimo las comillas dobles de la primera posición de la línea.
                //Con el valor 'linea.length()-1' suprimo las comillas dobles de la última posición de la línea.
                tokens = linea.substring(1, linea.length() - 1).split("\",\"");

                //Creo un Empleado auxiliar en el que introduciré todos los datos mediante los setters.
                Vehiculo v1 = new Vehiculo();
                //Almaceno en cada atributo, la posición del array de tokens
                
                listaVehiculos.add(v1);
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        Comparator<Vehiculo> criterioMarca = (v1, v2) -> v1.getMarca().compareTo(v2.getMarca());
        Collections.sort(listaVehiculos, criterioMarca);
        System.out.println("\nIMPRIMIENDO VEHICULOS ORDENADOS POR MARCA");
        for (Vehiculo veh : listaVehiculos) {
            veh.getAtributos();
        }
        
        
        
    }

}
