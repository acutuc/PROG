package ej2ficheros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author acutuc
 */
public class Ej2Escribir {

    /*2.- Implementa un programa que vaya escribiendo líneas de texto en un archivo.
    El archivo se llamará “teclado.txt” y se creará en la raíz del proyecto.
    El programa irá solicitando líneas de texto al usuario (cada línea termina con un salto de línea , ‘\n’) y las irá escribiendo en el fichero.
    Cuando en una nueva línea el usuario introduzca el texto “EOF”, el programa terminará y esa línea no se escribirá en el fichero.
    Controla las posibles excepciones que pudieran ocurrir.*/
    public static void main(String[] args) {
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idFichero = "teclado.txt";
        String tmp;

        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Escriba cadena de caracteres hasta teclear EOF:");
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            do {
                //Almaceno en una variable temporal lo que se recoge a través del teclado.
                tmp = entrada.nextLine();
                //Condición en la que si se escribe "eof", no se vuelque la información en el fichero y acabe el programa.
                if (tmp.equalsIgnoreCase("eof")) {
                    break;
                }
                //Vuelco las entradas de teclado en líneas con su correspondiente salto.
                flujo.write(tmp + "\n");
            } while (!tmp.equalsIgnoreCase("eof"));
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
