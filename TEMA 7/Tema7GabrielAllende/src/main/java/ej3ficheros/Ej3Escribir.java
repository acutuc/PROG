package ej3ficheros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author acutuc
 */
//Definición de la clase.
public class Ej3Escribir {
    /*3.- Implementa un programa que guarde exactamente 75 líneas de texto en un fichero, cuyo nombre se deja a tu elección
    En cada línea se irán generando letras aleatorias (entre la ‘a’ y la ‘Z’) y se irán separando por punto y coma (;)
    hasta que la letra que se vaya a escribir sea ‘g’ o ‘G’. En este caso, se escribe y se saltará a la línea siguiente.
    Posibles ejemplos de líneas generadas:
 
	a;C;T;B;D;s;u;i;w;g
	Q;w;e;r;t;y;S;H;J;K;G
	….
    */
    public static void main(String[] args) {
       // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idFichero = "ej3.txt";
        char tmp;
        
        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones        
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            for (int i = 0; i < 75; i++) {
                do{
                    //Almaceno en una variable temporal el char que se genera en el método.
                    tmp = generarLetraAleatoria();
                    //Vuelco los datos escritos en el fichero.
                    flujo.write(tmp + ";");
                }while(tmp != 'g' && tmp != 'G');
                //Hago un salto de línea.
                flujo.newLine();
            }
            //Almaceno los datos.
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    
    public static char generarLetraAleatoria(){
        Random aleatorio = new Random();
        
        String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz";
        
        int letraAleatoria = aleatorio.nextInt(letras.length());
        
        char charAleatorio = letras.charAt(letraAleatoria);
        
        return charAleatorio;
    }
}
