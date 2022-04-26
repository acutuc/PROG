package ej7leerficheroej4;

import ej4ficherosvehiculos.Deportivo;
import ej4ficherosvehiculos.Furgoneta;
import ej4ficherosvehiculos.Turismo;
import ej4ficherosvehiculos.Vehiculo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

        String idFichero = "vehiculos.txt";
        String[] tokens;
        String linea;

        //try-with-resources para leer el fichero "vehiculos.txt".
        try (Scanner datosFichero = new Scanner(new FileReader(idFichero))) {

            while (datosFichero.hasNextLine()) {

                linea = datosFichero.nextLine();

                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador coma
                tokens = linea.substring(4).split(":");

                if (linea.charAt(0) == '0') {
                    Turismo t1 = new Turismo();
                    t1.setBastidor(Long.parseLong(tokens[0]));
                    t1.setMatricula(tokens[1]);
                    t1.setMarca(tokens[2]);
                    t1.setModelo(tokens[3]);
                    t1.setColor(tokens[4]);
                    t1.setTarifa(Double.parseDouble(tokens[5]));
                    t1.setDisponible(Boolean.parseBoolean(tokens[6]));
                    t1.setPuertas(Integer.parseInt(tokens[7]));
                    t1.setMarchaAutomatica(Boolean.parseBoolean(tokens[8]));

                    listaVehiculos.add(t1);
                } else if (linea.charAt(0) == '1') {
                    Deportivo d1 = new Deportivo();
                    d1.setBastidor(Long.parseLong(tokens[0]));
                    d1.setMatricula(tokens[1]);
                    d1.setMarca(tokens[2]);
                    d1.setModelo(tokens[3]);
                    d1.setColor(tokens[4]);
                    d1.setTarifa(Double.parseDouble(tokens[5]));
                    d1.setDisponible(Boolean.valueOf(tokens[6]));
                    d1.setCilindrada(Integer.parseInt(tokens[7].substring(0, tokens[7].length() - 1)));

                    listaVehiculos.add(d1);
                } else {
                    Furgoneta f1 = new Furgoneta();
                    f1.setBastidor(Long.parseLong(tokens[0]));
                    f1.setMatricula(tokens[1]);
                    f1.setMarca(tokens[2]);
                    f1.setModelo(tokens[3]);
                    f1.setColor(tokens[4]);
                    f1.setTarifa(Double.parseDouble(tokens[5]));
                    f1.setDisponible(Boolean.valueOf(tokens[6]));
                    f1.setCarga(Integer.parseInt(tokens[7]));
                    f1.setVolumen(Integer.parseInt(tokens[8].substring(0, tokens[8].length() - 1)));

                    listaVehiculos.add(f1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        //Ordeno por marca.
        Comparator<Vehiculo> criterioMarca = (v1, v2) -> v1.getMarca().compareTo(v2.getMarca());
        listaVehiculos.sort(criterioMarca);
        for (Vehiculo veh : listaVehiculos) {
            System.out.println(veh.getAtributos());
        }

    }

}
