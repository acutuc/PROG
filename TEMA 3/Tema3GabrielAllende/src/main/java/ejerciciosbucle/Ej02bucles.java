
package ejerciciosbucle;

import java.util.Scanner;

/**
 *
 * @author acutuc
 */
public class Ej02bucles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*2.-  Intenta averiguar qué realiza el siguiente programa, sin implementarlo.
        Implementa el programa en el entorno y compara tus resultados con la ejecución.*/
        
        Scanner teclado = new Scanner(System.in);
        int n, x;
        System.out.println("Ingrese el valor final:");
        n = teclado.nextInt();
        // Inicialización de la variables de control
        x = 1;
        // Condición del bucle. Se ejecuta mientras sea true
        while (x <= n) {
            // Bloque de sentencias
            System.out.print(x);
            System.out.print(" - ");
            // Actualización de la variable o variables de control
            x = x + 1;
        }
    }
}