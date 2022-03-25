/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jcarlos;

import java.util.Scanner;

/**
 *
 * @author profesor
 */
public class EjemplosIf {
    
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce tu edad: ");
        int edad = teclado.nextInt();
        System.out.println("Tu edad es: " + edad);
        
        if(edad<0 || edad > 150){
            System.out.println("La edad introducida es incorrecta");
        } else {
            System.out.println("La edad es correcta");
        }

    }
    
}
