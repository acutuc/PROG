package arrays;

import java.util.Scanner;

/**
 *
 * @author Gabriel
 */
public class Ej8 {

    /**
     * @param args the command line arguments
     */
    /*Realizar un programa que lea de la entrada un número y utilice ese número para crear un array de enteros de ese tamaño.
    A continuación, el programa inicializa el array con los valores que el usuario introduzca por teclado.
    Finalmente, se deberá recorrer el array e imprimir tantos caracteres ‘*’ como indique el valor de cada elemento del array.
    Ejemplo: los valores 5,4,3,2 producirán la siguiente salida:
    *****
    ****
    ***
    **
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduce el largo del array");
        int tamanio = entrada.nextInt();

        int[] array = new int[tamanio];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Introduce el valor en la posicion" + i);
            array[i] = entrada.nextInt();
        }

        for (int i = 0; i < array.length; i++) {
            int valor = array[i];
            for (int j = valor; j >= 0; j--) {
                System.out.print("*");
            }
            System.out.println("\n");
        }
    }

}
