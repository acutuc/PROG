package ejercicio;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author acutuc
 */
public class ParteB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Declaro variable boolean que utilizaré en el menú de opciones.
        boolean continuar = true;
        /*Se pregunta mediande entrada a teclado los nombres y si va a ser pares o 
        nones a los jugadores.*/
        Scanner entrada = new Scanner(System.in);
        Random entrada2 = new Random();
        System.out.println("Introduzca nombre del Jugador A: ");
        String nombreA = entrada.nextLine();
        System.out.println("Introduzca nombre del Jugador B: ");
        String nombreB = entrada.nextLine();
        /*Mediante bucles, nos aseguramos de que los jugadores tecleen sí o sí "pares" o "nones"
        (indiferentemente de si son mayúsculas o minúsculas)*/
        do {
            System.out.println(nombreA + " ,¿pares o nones?");
            String paresNonesA = entrada.nextLine();
            if (paresNonesA.equalsIgnoreCase("pares") || paresNonesA.equalsIgnoreCase("nones")) {
                continuar = true;
            } else {
                continuar = false;
            }
        } while (continuar != true);

        do {
            System.out.println(nombreB + " ,¿pares o nones?");
            String paresNonesB = entrada.nextLine();
            if (paresNonesB.equalsIgnoreCase("pares") || paresNonesB.equalsIgnoreCase("nones")) {
                continuar = true;
            } else {
                continuar = false;
            }
        } while (continuar != true);

        //Declaro las variables que utilizaré en el bucle posterior.
        int dedosA;
        int dedosB;

        //Se calcula de manera aleatoria la cantidad de dedos a sacar de cada jugador.
        dedosA = entrada2.nextInt(10 + 1);
        System.out.println(nombreA + " vas a sacar " + dedosA + " dedos.");
        dedosB = entrada2.nextInt(10 + 1);
        System.out.println(nombreB + " vas a sacar " + dedosB + " dedos.");

        /*If-else para saber si la suma de los dedos es par o impar, usando el modulo %
            para que nos diga si el resto es 0 (par) o no (impar).*/
        if ((dedosA + dedosB) % 2 == 0) {
            System.out.println("Suma " + (dedosA + dedosB) + ", gana " + nombreA);
        } else {
            System.out.println("Suma " + (dedosA + dedosB) + ", gana " + nombreB);
        }
    }

}
//https://github.com/acutuc/paresynones
