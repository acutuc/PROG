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
public class Ej6 {

    public static void main(String[] args) {

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
