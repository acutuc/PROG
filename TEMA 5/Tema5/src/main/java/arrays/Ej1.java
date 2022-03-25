
package arrays;

import java.util.Arrays;

/**
 *
 * @author acutuc
 */
public class Ej1 {

    /**
     * @param args the command line arguments
     */
    /*Escribe un programa que muestre cada elemento de un array de enteros y sume todos sus elementos.
    Instancia e inicializa el array en el programa, sin leer nada por teclado, con los siguientes valores {1, 2, 3, 4, 5, 6}.*/
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5, 6};
        
        int suma = 0;
        
        for (int i = 0; i < numeros.length; i++){
            suma += numeros[i];
            System.out.println("Suma acumulada: " + suma);
        }
        System.out.println("La suma de los elementos del array es de: " + suma);
    }
    
}
