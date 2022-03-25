package ejerciciosestructurasseleccion;

import java.util.Scanner;

public class EjEjemplo1estructurasseleccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //A. Saber si un número es positivo, negativo, o cero

        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el número");
        int numero = teclado.nextInt();

        if (numero > 0) {
            System.out.println("El número es positivo");
        } 
        else if (numero == 0) {
            System.out.println("El número es cero");
        } 
        else {
            System.out.println("El número es negativo");

        }
    }

}
