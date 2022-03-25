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
public class DigitoMayusMinus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un caracter: ");
        // Leemos un caracter o un palabra
        String caracter = teclado.next();
        System.out.println("String introducido: " + caracter);
        // Con el método charAt(posición) obtenemos un char del string que 
        // llama al método
        char charCaracter = caracter.charAt(0);
        System.out.println("Char en posición 0: " + charCaracter);
        
        // Usamos un int para guardar el unicode de ese char
       
        if (charCaracter>=48&&charCaracter<=57){
            System.out.println("Es un número (0...9)");
        } else if (charCaracter>=65&&charCaracter<=90){ // El número no está entre 48 y 57
            System.out.println("Es una mayúscula");
        } else if(charCaracter>=97&&charCaracter<=122){
            System.out.println("Es una minúscula");
        } else{
            System.out.println("Es otro caracter");
        }
        
    }
    
}
