/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author acutuc
 */
public class ej5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = false;
        int opcion = 0;
        do {
            System.out.println("Menú de opciones:");
            System.out.println("------------------");
            System.out.println("1. Cuenta atrás.");
            System.out.println("2. Juego de dados.");
            System.out.println("3. Salir.");
            do {
                try {
                    System.out.println("Seleccione una opción.");
                    opcion = sc.nextInt();
                    continuar = true;
                } catch (InputMismatchException ime) {
                    System.out.println("¡Debe elegir una opción del menú!");
                    continuar = false;
                    sc.nextLine();
                }
            } while (!continuar);

            switch (opcion) {
                case 1:
                    System.out.println("Se realizará la cuenta atrás: ");
                    for(int i = 1000; i != 95; i= i-5) {
                    System.out.println(i + " - ");
                    }
                    break;

                case 2:

                    break;
                case 3:

                    break;
            }
        } while (opcion != 3);
        do {
            System.out.println("¿Desea salir? Para salir escriba SI.");
            String salir = sc.next();
            continuar = salir.equalsIgnoreCase("si");

        } while (!continuar);

    }

}
