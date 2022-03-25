package arrays;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author acutuc
 */
public class Ej7 {

    /**
     * @param args the command line arguments
     */
    /*
    7. Escribir un programa que lea del teclado el tamaño de dos arrays de enteros (el mismo tamaño para los dos arrays).
    El programa inicializará los arrays con números aleatorios entre 1 y 100.
    Existirá un método llamado multiplicar que recibirá los dos arrays e irá multiplicando los elementos dos a dos,
    empezando por los elementos que ocupan la posición cero, luego la uno, etc, guardando el resultado en otro array,
    que será devuelto por el método. Además existirá un método para imprimir por pantalla los valores de los arrays.
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        //Declaro variable que establece el tamaño de los arrays.
        int tamanio;

        System.out.println("Introduzca el tamaño del array: ");
        tamanio = entrada.nextInt();

        //Declaro los dos arrays con los que trabajaremos el ejercicio.
        int[] array1 = new int[tamanio];
        int[] array2 = new int[tamanio];
        generarAleatorios(array1, array2);
        
        //Declaro array en la que se almacenará el resultado de multiplicar los dos arrays anteriores.
        
        //int[] arrayResultado = multiplicar(array1, array2);
        imprimir(array1);
        imprimir(array2);
        imprimir(multiplicar(array1, array2));
    }
    
    private static void generarAleatorios (int[] array1, int[] array2){
        int tamanio = array1.length;
        Random aleatorio = new Random();
        for (int i = 0; i < tamanio; i++) {
            array1[i] = aleatorio.nextInt(100)+1;
            array2[i] = aleatorio.nextInt(100)+1;
        }
    }
    
    private static int[] multiplicar(int[] array1, int[] array2) {
        int[] arrayMultiplicado = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            arrayMultiplicado[i] = array1[i] * array2[i];
        }
        return arrayMultiplicado;
    }
    
    private static void imprimir(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println("\n");
    }
}