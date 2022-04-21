package ej7leerficheroej4;

import ej4ficherosvehiculos.Deportivo;
import ej4ficherosvehiculos.Furgoneta;
import ej4ficherosvehiculos.Turismo;
import ej4ficherosvehiculos.Vehiculo;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

        try ( BufferedReader datosFichero = new BufferedReader(new InputStreamReader(new FileInputStream(idFichero)))) {
            //Imprimo el fichero original.
            while ((linea = datosFichero.readLine()) != null) {
                tokens = linea.substring(4).split(":");
                for (String token : tokens) {
                    System.out.print(token + ":");
                    for (Vehiculo veh : listaVehiculos) {
                        if(veh instanceof Deportivo){
                            veh.setBastidor(Long.parseLong(token));
                            listaVehiculos.add(veh);
                        }
                    }
                }
                System.out.println();
            }
        }
        Comparator<Vehiculo> criterioMarca = (v1, v2) -> v1.getMarca().compareTo(v2.getMarca());
        Collections.sort(listaVehiculos, criterioMarca);
        System.out.println("\nIMPRIMIENDO VEHICULOS ORDENADOS POR MARCA");
        for (Vehiculo veh : listaVehiculos) {
            veh.getAtributos();
        }
        
        
        
    }

}
