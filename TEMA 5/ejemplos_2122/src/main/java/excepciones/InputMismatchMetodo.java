/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author profesor
 */
public class InputMismatchMetodo {
    
    private static int pedirInt() {
        Scanner teclado = new Scanner(System.in);
        boolean seguir = true;
        int numero = 0;
        do {
            // Bloque try. Aquí se pone el código susceptible de error
            try {
                System.out.println("Introduce un dato int: ");
                numero = teclado.nextInt();
                seguir = false;

            } catch (InputMismatchException ime) {

                System.out.println("Cuidado pecador, te has equivocado. "
                        + "Introduce solo números");
                teclado.nextLine();
            } 
        } while (seguir);
        return numero;
    }
    
    private static boolean n1MayorN2(int n1, int n2){

        return n1>n2;
    }
    
    public static void main(String[] args) {

        int numero1 = 0, numero2 = 0, division = 0;
        
        numero1 = pedirInt();
        numero2 = pedirInt();

        if (n1MayorN2(numero1, numero2)){
            System.out.println("El número 1 es mayor");
        }
        
        System.out.println("Resultado1: " + numero1);
        System.out.println("Resultado2: " + numero2);

    }

    

}
