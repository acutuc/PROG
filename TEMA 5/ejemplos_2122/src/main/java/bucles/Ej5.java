/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bucles;

import java.util.Scanner;

/**
 *
 * @author profesor
 */
public class Ej5 {

    public static void main(String[] args) {

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
