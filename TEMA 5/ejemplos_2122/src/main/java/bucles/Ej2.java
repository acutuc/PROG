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
public class Ej2 {

    public static void main(String[] args) {

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
