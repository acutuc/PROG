/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jcarlos;

import java.util.Scanner;

/**
 *
 * @author profesor
 */
public class NumerosPositivoNegativoCero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un número: ");
        int numero = teclado.nextInt();

        if (numero < 0) {
            System.out.println("Es negativo");
        } else {
            if (numero > 0) {
                System.out.println("Es positivo");
            } else {
                System.out.println("Es cero");
            }
        }

        if (numero < 0) {
            System.out.println("Es negativo");
        } else if (numero > 0) {
            System.out.println("Es positivo");
        } else {
                System.out.println("Es cero");
            }
        }

    

}
