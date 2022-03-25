/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios;

import javax.swing.JOptionPane;

/**
 *
 * @author acutuc
 */
public class ej2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean continuar = true;
        int a = 0;
        int b = 0;
        int c = 0;
        do{
            try{
        String aString = JOptionPane.showInputDialog("Introduzca el valor de a");
        a = Integer.parseInt(aString);
        continuar = false;
            } catch (NumberFormatException nfe){
                System.out.println("¡Debe introducir un carácter numérico!");
                continuar = true;
            }
        }while (continuar);
        
        do{
            try{
        String bString = JOptionPane.showInputDialog("Introduzca el valor de b");
        b = Integer.parseInt(bString);
        continuar = false;
            } catch (NumberFormatException nfe){
                System.out.println("¡Debe introducir un carácter numérico!");
                continuar = true;
            }
        }while (continuar);
        
        do{
            try{
        String cString = JOptionPane.showInputDialog("Introduzca el valor de c");
        c = Integer.parseInt(cString);
        continuar = false;
            } catch (NumberFormatException nfe){
                System.out.println("¡Debe introducir un carácter numérico!");
                continuar = true;
            }
        }while (continuar);
        
        if (a == 0 && b == 0) {
            System.out.println("La ecuación no tiene solución");
        } else if (a == 0 && b != 0) {
            int solucion = -c / b;
            System.out.println("El resultado es " + solucion);
        } else {
            int solucion2 = (int) (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c)) / (2 * a));
            int solucion3 = (int) (-b - Math.sqrt(Math.pow(b, 2) - (4 * a * c)) / (2 * a));
            if(Math.pow(b, 2) - (4 * a * c) < 0){
                System.out.println("Los valores suministrados no permiten calcular las soluciones "
                        + "de la ecuación.");
            } else
            System.out.println("Las dos posibles soluciones son: " + solucion2 + " y " + solucion3);

        }

    }

}
