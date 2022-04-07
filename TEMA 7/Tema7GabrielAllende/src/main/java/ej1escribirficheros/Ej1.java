package ej1escribirficheros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author acutuc
 */
public class Ej1 {

    public static void main(String[] args) {
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idfichero = "matriz.txt";

        // Array a escribir
        int[][] numeros = new int[4][4];
        String tmp;

        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones        
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idfichero))) {

           for (int i = 0; i < numeros.length; i++) {
               numeros[i][0]= 100 * (i+1);
                for (int j = 0; j < numeros[i].length; j++) {
                    numeros[i][j] = numeros[i][0] + 1*j;
                    // Obtengo en un String el elemento int de la matriz
                    tmp = String.valueOf(numeros[i][j]);
                    
                        flujo.write(tmp + "\t");
                    
                }
                // Metodo newLine() añade salto de línea después de cada fila
                flujo.newLine();
            }
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idfichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
