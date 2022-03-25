package arrays;

import java.util.Scanner;

/**
 *
 * @author acutuc
 */
public class Ej2 {

    /**
     * @param args the command line arguments
     */
    /*Escribe un programa para leer la altura de un número determinado de personas y calcular la altura media.
    El número de personas se pide por teclado y debe ser entero un entero mayor que cero.
    Posteriormente el programa irá pidiendo la altura, en cm, de cada una de las personas y las guardará en una estructura de almacenamiento.
    Si la altura leída no es positiva, el programa la pasará a número positivo.
    También es necesario saber cuántas personas tienen una altura superior a la media e inferior a la media.*/
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca cantidad de personas: ");
        int cantidadPersonas = entrada.nextInt();
        do
        {
            if (cantidadPersonas <= 0)
            {
                System.out.println("El valor a introducir tiene que ser mayor que 0. Vuelva a introducir cantidad de personas: ");
                cantidadPersonas = entrada.nextInt();
                entrada.nextLine();
            }
        } while (cantidadPersonas <= 0);
        int personas[] = new int[cantidadPersonas];
        int alturaCM;
        
        //Bucle desde 0 hasta la última posición de personas.
        for (int i = 0; i < personas.length; i++)
        {
            System.out.println("Introduzca la altura en cm: ");
            alturaCM = entrada.nextInt(); //Guardo el valor introducido por teclado.
            entrada.nextLine();
            personas[i] = alturaCM; //Asigno el valor introducido a la posición.
            System.out.println("Altura de persona " + (i + 1) + ": " + personas[i]);
        }
    }

}
