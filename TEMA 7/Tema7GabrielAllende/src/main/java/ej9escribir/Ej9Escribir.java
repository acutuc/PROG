package ej9escribir;

import ej4ficherosvehiculos.Deportivo;
import ej4ficherosvehiculos.Furgoneta;
import ej4ficherosvehiculos.Turismo;
import ej4ficherosvehiculos.Vehiculo;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gabriel
 */
//Definición de la clase
public class Ej9Escribir {

    /*9.- Realiza una modificación sobre el programa del ejercicio 7 para que divida la única lista de objetos Vehiculo en tres listas específicas de objetos Turismo, Deportivo y Furgoneta. 
    Una vez generadas las tres listas, guarda en tres ficheros CSV (*.csv) los vehículos correspondientes a cada lista, separando cada campo usando el carácter delimitador punto y coma (;).
    Abre los ficheros CSV usando un programa de hoja de cálculo, indicando que la separación de campos se realiza usando ;, y comprueba que cada campo se encuentra en una columna diferente.*/
    public static void main(String[] args) throws IOException {
        //COPIO EL EJERCICIO 7
        //ArrayList en el que almacenaré todos los objetos de tipo Vehiculo.
        ArrayList<Turismo> listaTurismos = new ArrayList<>();
        ArrayList<Deportivo> listaDeportivos = new ArrayList<>();
        ArrayList<Furgoneta> listaFurgonetas = new ArrayList<>();

        String idFichero = "vehiculos.txt";

        String ficheroTurismos = "turismos.csv";
        String ficherosDeportivos = "deportivos.csv";
        String ficherosFurgonetas = "furgonetas.csv";

        
        
        

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

                    listaTurismos.add(t1);
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

                    listaDeportivos.add(d1);
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

                    listaFurgonetas.add(f1);
                }

            }
        }
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(ficheroTurismos))) {
            for (Turismo tur : listaTurismos) {
                flujo.write(tur.getBastidor() + ";" + tur.getMatricula() + ";" + tur.getMarca() + tur.getModelo() + ";"
                        + tur.getColor() + ";" + tur.getTarifa() + ";" + tur.isDisponible() + ";" + tur.getPuertas() + ";"
                        + tur.isMarchaAutomatica());
                flujo.newLine();

            }
            // Metodo flush() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + ficheroTurismos + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(ficherosDeportivos))) {
            for (Deportivo dep : listaDeportivos) {
                flujo.write(dep.getBastidor() + ";" + dep.getMatricula() + ";" + dep.getMarca() + dep.getModelo() + ";"
                        + dep.getColor() + ";" + dep.getTarifa() + ";" + dep.isDisponible() + ";" + dep.getCilindrada());
                flujo.newLine();
            }
            // Metodo flush() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + ficherosDeportivos + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(ficherosFurgonetas))) {
            for (Furgoneta fur : listaFurgonetas) {
                flujo.write(fur.getBastidor() + ";" + fur.getMatricula() + ";" + fur.getMarca() + fur.getModelo() + ";"
                        + fur.getColor() + ";" + fur.getTarifa() + ";" + fur.isDisponible() + ";" + fur.getCarga() + ";" + 
                        fur.getVolumen());
                flujo.newLine();
            }
            // Metodo flush() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + ficherosFurgonetas + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
