package ejercicio;

import java.util.Scanner;

/**
 *
 * @author acutuc
 */
public class ParteA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Declaro variable booleana que utilizaré en el posterior menú.
        boolean continuar = true;

        /*Se pregunta mediande entrada a teclado los nombres y si va a ser pares o 
        nones a los jugadores.*/
        Scanner entrada = new Scanner(System.in);
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
        int dedosB;/*If-else para saber si la suma de los dedos es par o impar, usando el modulo %
            para que nos diga si el resto es 0 (par) o no (impar).*/

        //Se pide la cantidad de dedos a sacar de cada jugador.;
        //Dedos del Jugador A:
        System.out.println(nombreA + " ,¿cuántos dedos vas a sacar?");
        dedosA = entrada.nextInt();

        //If-else para que el Jugador A no pueda sacar menos de 0 dedos o más de 10.
        if (dedosA > 10 || (dedosA < 0)) {
            do {
                System.out.println(nombreA + "Incorrecto, sólo puede sacar de 0 a 10 dedos.");
                dedosA = entrada.nextInt();
            } while (dedosA > 10 || (dedosA < 0));
        } else {

            //Dedos del Jugador B:
            System.out.println(nombreB + ", ¿cuántos dedos vas a sacar?");
            dedosB = entrada.nextInt();
            /*Dentro del else, abro otro if-else para el Jugador B, para que tampoco pueda
        sacar menos de 0 o más de 10*/
            if (dedosB > 10 || (dedosB < 0)) {
                do {
                    System.out.println(nombreB + "Incorrecto, sólo puede sacar de 0 a 10 dedos.");
                    dedosB = entrada.nextInt();
                } while (dedosB > 10 || (dedosB < 0));
            } else /*If-else para saber si la suma de los dedos es par o impar, usando el modulo %
            para que nos diga si el resto es 0 (par) o no (impar).*/ if ((dedosA + dedosB) % 2 == 0) {
                System.out.println("Suma " + (dedosA + dedosB) + ", gana " + nombreA);
            } else {
                System.out.println("Suma " + (dedosA + dedosB) + ", gana " + nombreB);
            }

        }

    }
}
//https://github.com/acutuc/paresynones
