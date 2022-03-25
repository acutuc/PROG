/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author acutuc
 */
public class ej6 {

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
                    
                    break;

                case 2:
                    Random numAleatorio = new Random();
                    int moneda = numAleatorio.nextInt(2)+1;
                    int cara = 1;
                    int cruz = 2;
                    if (moneda == cara){
                        int dado = numAleatorio.nextInt(6)+1;
                        if (dado == 1 || dado == 3){
                            System.out.println("¡Ha gando un fabuloso viaje a las Charcas "
                                    + "de las Nutrias!");
                        } else if (dado == 2 || dado == 6){
                            System.out.println("¡Ha gando un fabuloso viaje al parque de los "
                                    + "Pedregales!");
                        }
                            
                    }else
                        System.out.println("¡Ha ganado un fabuloso viaje a los dólmenes de "
                                + "Corominas!");
                        
                    break;
                    
                case 3:
                    
                    break;
            }
        } while (opcion != 3);
        do{
            System.out.println("¿Desea salir? Para salir escriba SI.");
        String salir = sc.next();
        continuar = salir.equalsIgnoreCase("si");
        
        }while (!continuar);

    }

}
