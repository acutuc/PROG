package arrays;

import java.util.Scanner;

/**
 *
 * @author Gabriel
 */
public class Ej4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Escribe un programa que, dado un array de enteros de cualquier tamaño,
        busque si un número obtenido por teclado se encuentra en el array e imprima la primera posición en la que se encuentra el número.
        Realiza la búsqueda de un elemento:
        a) implementando el método de búsqueda secuencial. 
        b) usando el método de búsqueda binaria de la clase Arrays.*/
        
        //Declaro e inicializo array con valores enteros.
        int[] array = {1, 7, 2, 3, 4, 300, 52, 5};
        
        //Declaro el int del número a encontrar.
        int numeroAEncontrar;
        
        /*Declaro e inicializo para poder utilizar en el bucle, un int que nos da la posición
        del número en caso de haber sido encontrado.*/
        int posicion = 0;
        
        //Boolean que controla si se encuentra el número o no.
        boolean localizado = false;
        
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce el número a encontrar");
        numeroAEncontrar = entrada.nextInt();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == numeroAEncontrar) {
                posicion = i;
                localizado = true;
            }
        }
        if (localizado) {
            System.out.println("La posicion del array es: " + posicion);
        } else {
            System.out.println("El número no se encuentra en el array");
        }
        metodoBurbuja(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    //Método que ordena el array.
    private static void metodoBurbuja(int[] arrayRecibe) {
        int tmp;
        for (int i = 0; i < arrayRecibe.length - 1; i++) {
            for (int j = i + 1; j < arrayRecibe.length; j++) {
                if (arrayRecibe[i] > arrayRecibe[j]) {
                    tmp = arrayRecibe[i];
                    arrayRecibe[i] = arrayRecibe[j];
                    arrayRecibe[j] = tmp;
                }
            }

        }
    }

}
