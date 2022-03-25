package metodos;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author acutuc
 */
public class EjercicioMetodosNumeroAleatorio {

    private static void mostrarMenu() {
        System.out.println("Bienvenido al juego de números aleatorios.");
        System.out.println("-------------------------");
        System.out.println("1 - Iniciar el juego");
        System.out.println("2 - Salir");
    }

    private static int numeroAlAzar() {
        Random numeroAleat = new Random();
        int numeroGenerado = numeroAleat.nextInt(10) + 1;
        return numeroGenerado;
    }

    public static void main(String[] args) {
        // 1. Método que genere un número aleatorio (a, b).
        /* 2. Darle 3 oportunidades al usuario (pudiéndose cambiar la cantidad de oportunidades)
              de acertar el número.*/

        Scanner sc = new Scanner(System.in);
        int oportunidades = 0; //Cantidad de vidas de las que el usuario dispondrá.
        int numero = 0; //Número introducido por el usuario, para adivinar.
        boolean filtro = true;
        int contadorOportunidades = 0; //Utilizado en el bucle para restar vidas al usuario.
        int opcion = 0;

        //Bucle para que el usuario juegue hasta que finalice el programa.
        do {
            /* Try/catch para descartar la posible entrada de caracteres no numéricos
            en la selección de opciones del menú principal. */
            try {
                mostrarMenu(); //Llamamos al método que nos enseñará el menú.
                opcion = sc.nextInt(); //Introducimos la opción para jugar o abandonar la partida.
            } catch (InputMismatchException ime) {
                System.out.println("Sólo puede introducir caracteres numéricos.");
                sc.nextLine();
            }
            
            //Switch para elegir entre las dos opciones: Jugar o salir.
            switch (opcion) {
                case 1:
                    System.out.println("Ha seleccionado iniciar el juego.");
                    try { /* Try-catch para descartar la posible entrada de caracteres no numéricos
                          en la selección de cantidad de vidas del jugador. */
                        System.out.println("Introduzca cuántas vidas quieres tener.");
                        oportunidades = sc.nextInt(); //Cantidad de vidas de las que el usuario dispondrá.
                    } catch (InputMismatchException ime) {
                        System.out.println("Sólo puede introducir caracteres numéricos.");
                        sc.nextLine();
                    }
                    
                    //Bucle para obligar al jugador a utilizar más de 0 vidas, con su respectivo try/catch.
                    do {
                        if (oportunidades <= 0) {
                            try {
                                System.out.println("¡Tiene que elegir un número válido de vidas!");
                                oportunidades = sc.nextInt();
                            } catch (InputMismatchException ime) {
                                System.out.println("Sólo puede introducir caracteres numéricos.");
                                sc.nextLine();
                            }
                        } else {
                            filtro = false;
                        }
                    } while (filtro == true);
                    
                    System.out.println("¡Intente adivinar el número! El número generado será del "
                            + "1 al 10.");
                    
                    /* Bucle que restará vidas al jugador en caso de no acertar.
                    Acabará o bien cuando se quede sin vidas, o bien cuando acierte el número */
                    do {
                        try { /*Try-catch para descartar la posible entrada de caracteres no numéricos
                                en los intentos del jugador. */
                            System.out.println("Introduzca un número válido (del 1 al 10). Tiene aún "
                                    + oportunidades + " vidas.");
                            numero = sc.nextInt();
                            
                            //Bucle para obligar al jugador a poner números del 1 al 10, con su try/catch.
                            do {
                                if (numero <= 0 || numero > 10) {
                                    try { //Aquí los try/catch restarán vidas.
                                        System.out.println("¡Tiene que elegir un número del 1 al 10!");
                                        numero = sc.nextInt();
                                    } catch (InputMismatchException ime) {
                                        System.out.println("Sólo puede introducir caracteres numéricos. Se le restará una vida...");
                                        sc.nextLine();
                                    }
                                } else {
                                    filtro = false;
                                }
                            } while (filtro == true);
                        } catch (InputMismatchException ime) {
                            System.out.println("¡Sólo caracteres numéricos! Se le restará una vida...");
                            sc.nextLine();
                        }
                        oportunidades--;
                    } while (((oportunidades != 0)
                            && (numero != numeroAlAzar())));
                    if (oportunidades == 0) {
                        System.out.println("Ha perdido la partida... lo sentimos mucho");
                    } else {
                        System.out.println("¡Ha ganado el juego! Ha acertado con aún " + oportunidades + " "
                                + "vidas restantes");
                    }
                    break;
                case 2:
                    System.out.println("Ha seleccionado salir del juego.");
                    break;
                default:
                    System.out.println("Tiene que seleccionar una opción del menú.\n");
            }
        } while (opcion != 2);

    }
}
