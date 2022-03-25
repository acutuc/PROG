
package ejerciciosbucle;

import java.util.Scanner;

/**
 *
 * @author acutuc
 */
public class Ej06bucles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //6.- Implementa el programa del ejercicio 2 usando un for. 

        // El bucle for se utiliza normalmente cuando se sabe
        // el número de iteraciones a realizar
        Scanner teclado = new Scanner(System.in);
        int n;
        System.out.println("Ingrese el valor final:");
        n = teclado.nextInt();

        // Inicialización de la variables de control
        // Condición del bucle. Se ejecuta mientras sea true
        // Actualización de la variable o variables de control
        for (int x = 1; x <= n; x++) {
            // Bloque de sentencias
            System.out.print(x);
            System.out.print(" - ");
            
        }

        

    }

}
