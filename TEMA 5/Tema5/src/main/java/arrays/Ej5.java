package arrays;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author acutuc
 */
public class Ej5 {

    /**
     * @param args the command line arguments
     */
    /*Implementa un programa que guarde en un array 10 números enteros que se leen por teclado.
    A continuación se recorre el array y calcula el número total de positivos, de negativos y de ceros.
    Calcula y muestra la media aritmética de los valores positivos y la de los valores negativos del array.
    Implementar métodos para:

    a) Leer valores por teclado y almacenarlos en el array. Se le pasará el array como parámetro y no devolverá nada.
    b) Contar positivos, se le pasará el array como parámetro y devolverá el número de positivos almacenados en el array. 
    c) Contar negativos, se le pasará el array como parámetro y devolverá el número de negativos almacenados en el array. 
    d) Contar ceros, se le pasará el array como parámetro y devolverá el número de ceros almacenados en el array. 
    e) Mostrar array, se le pasará el array como parámetro y no devolverá nada, sólo imprimirá por pantalla el array.
    f) Calcular media positivos, se le pasará el array como parámetro y no devolverá nada, sólo imprimirá por pantalla la media aritmética de los positivos.
    g) Calcular media negativos, se le pasará el array como parámetro y no devolverá nada, sólo imprimirá por pantalla la media aritmética de los negativos.*/
    public static void main(String[] args) {
        // Declaro e inicializo array con diez números enteros.
        int[] listaNumeros = new int[10];

        array10Numeros(listaNumeros); // a)
        contadorPositivos(listaNumeros); // b)
        contadorNegativos(listaNumeros); // c)
        contadorCeros(listaNumeros); // d)
        mostrarArray(listaNumeros); // e)
        mediaPositivos(listaNumeros); // f)
        mediaNegativos(listaNumeros); // g)
    }

    // a) Leer valores por teclado y almacenarlos en el array. Se le pasará el array como parámetro y no devolverá nada.
    private static void array10Numeros(int[] array) {
        Scanner entrada = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.println("Introduzca 10 números enteros. Número " + (i + 1) + ": ");
            array[i] = entrada.nextInt();
        }

    }

    // b) Contar positivos, se le pasará el array como parámetro y devolverá el número de positivos almacenados en el array.
    private static int contadorPositivos(int[] array) {
        int contadorPositivos = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                contadorPositivos++;
            }
        }
        return contadorPositivos;
    }

    // c) Contar negativos, se le pasará el array como parámetro y devolverá el número de negativos almacenados en el array.
    private static int contadorNegativos(int[] array) {
        int contadorNegativos = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                contadorNegativos++;
            }
        }
        return contadorNegativos;
    }

    // d) Contar ceros, se le pasará el array como parámetro y devolverá el número de ceros almacenados en el array. 
    private static int contadorCeros(int[] array) {
        int contadorCeros = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                contadorCeros++;
            }
        }
        return contadorCeros;
    }

    // e) Mostrar array, se le pasará el array como parámetro y no devolverá nada, sólo imprimirá por pantalla el array.
    private static void mostrarArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Posición " + (i) + " del array, que almacena el número " + array[i]);
        }
    }

    // f) Calcular media positivos, se le pasará el array como parámetro y no devolverá nada, sólo imprimirá por pantalla la media aritmética de los positivos.
    private static void mediaPositivos(int[] array) {
        int sumaAcumulada = 0;
        int sumaElementos = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                sumaAcumulada += array[i];
                sumaElementos++;
            }
        }
        int media = sumaAcumulada/sumaElementos;
        System.out.println("La media de los números positivos es: " + media);
    }

    // g) Calcular media negativos, se le pasará el array como parámetro y no devolverá nada, sólo imprimirá por pantalla la media aritmética de los negativos.
    private static void mediaNegativos(int[] array) {
        int sumaAcumulada = 0;
        int sumaElementos = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                sumaAcumulada += array[i];
                sumaElementos++;
            }
        }
        int media = sumaAcumulada/sumaElementos;
        System.out.println("La media de los números positivos es: " + media);
    }
}