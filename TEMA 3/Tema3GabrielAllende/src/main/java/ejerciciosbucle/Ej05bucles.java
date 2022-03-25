package ejerciciosbucle;

import java.util.Scanner;

/**
 *
 * @author acutuc
 */
public class Ej05bucles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //5.- Implementa el programa del ejercicio 2 usando un do – while.
        // El bucle do while primero ejecuta todo el bloque de código
        // al menos una vez y luego mira la condición
        Scanner teclado = new Scanner(System.in);
        int n, x;
        System.out.println("Ingrese el valor final:");
        n = teclado.nextInt();
        // Inicialización de la variables de control
        x = 1;
        // Condición del bucle. Se ejecuta mientras sea true
        do {
            // Bloque de sentencias
            System.out.print(x);
            System.out.print(" - ");
            // Actualización de la variable o variables de control
            x = x + 1;
        } while (x <= n);

    }
}