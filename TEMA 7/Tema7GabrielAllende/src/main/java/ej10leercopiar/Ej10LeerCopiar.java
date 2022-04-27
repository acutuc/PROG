package ej10leercopiar;

import ej4ficherosvehiculos.Deportivo;
import ej4ficherosvehiculos.Furgoneta;
import ej4ficherosvehiculos.Turismo;
import ej4ficherosvehiculos.Vehiculo;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author acutuc
 */
//Definición de la clase.
public class Ej10LeerCopiar {

    /*10.- Implementa un programa para leer los ficheros de texto del ejercicio anterior, de forma que se guarden en una única lista de Vehículos los objetos leídos de cada fichero. El programa debe realizar lo siguiente:
    - Copiar los tres ficheros *.csv a un directorio previamente creado en “./copias”.
    - Mostrar los ficheros contenidos en “copias”.
    - Leer los ficheros de la carpeta “copias” e ir guardando los objetos en una lista de vehículos.
    - Imprimir la lista por pantalla. 
    - Ordena la lista por bastidor.
    - Imprimir la lista ordenada.
    - Borrar los ficheros *.csv originales.
    - Mostrar el contenido de la carpeta donde estaban los *.csv originales.
    - Usando Streams, realiza las siguientes acciones sobre la lista de vehículos:
        - Imprime por pantalla todos los coches blancos, distintos, ordenador por matrícula.
        - Imprime por pantalla todas las marcas de coches distintas de aquellos coches que estén disponibles.
        - Saber la cantidad de vehículos Citroen.
        - Comprueba si hay algún Peugeot negro disponible en la lista.*/
    public static void main(String[] args) throws FileNotFoundException {
        //ArrayList de Vehículos en el que almacenaré todos los objetos de tipo Vehiculo.
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();

        //Nombre de los ficheros.
        String idFichero = "vehiculos.txt";
        String ficheroTurismos = "turismos.csv";
        String ficherosDeportivos = "deportivos.csv";
        String ficherosFurgonetas = "furgonetas.csv";

        String[] tokens;
        String linea;

        //try-with-resources para leer el fichero "vehiculos.txt".
        try ( Scanner datosFichero = new Scanner(new FileReader(ficheroTurismos))) {
            while (datosFichero.hasNextLine()) {

                linea = datosFichero.nextLine();

                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador coma
                tokens = linea.split(";");
                Vehiculo v1 = new Vehiculo();
                v1.setBastidor(Long.parseLong(tokens[0]));
                v1.setMatricula(tokens[1]);
                v1.setMarca(tokens[2]);
                v1.setModelo(tokens[3]);
                v1.setColor(tokens[4]);
                v1.setTarifa(Double.parseDouble(tokens[5]));
                v1.setDisponible(Boolean.parseBoolean(tokens[6]));

                listaVehiculos.add(v1);
            }
        }
        try ( Scanner datosFichero = new Scanner(new FileReader(ficherosDeportivos))) {
            while (datosFichero.hasNextLine()) {

                linea = datosFichero.nextLine();

                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador coma
                tokens = linea.split(";");
                Vehiculo v1 = new Vehiculo();
                v1.setBastidor(Long.parseLong(tokens[0]));
                v1.setMatricula(tokens[1]);
                v1.setMarca(tokens[2]);
                v1.setModelo(tokens[3]);
                v1.setColor(tokens[4]);
                v1.setTarifa(Double.parseDouble(tokens[5]));
                v1.setDisponible(Boolean.parseBoolean(tokens[6]));

                listaVehiculos.add(v1);
            }
        }
        try ( Scanner datosFichero = new Scanner(new FileReader(ficherosFurgonetas))) {
            while (datosFichero.hasNextLine()) {

                linea = datosFichero.nextLine();

                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador coma
                tokens = linea.split(";");
                Vehiculo v1 = new Vehiculo();
                v1.setBastidor(Long.parseLong(tokens[0]));
                v1.setMatricula(tokens[1]);
                v1.setMarca(tokens[2]);
                v1.setModelo(tokens[3]);
                v1.setColor(tokens[4]);
                v1.setTarifa(Double.parseDouble(tokens[5]));
                v1.setDisponible(Boolean.parseBoolean(tokens[6]));

                listaVehiculos.add(v1);
            }
        }
        listaVehiculos.forEach(System.out::println);
    }
}
