package ejercicio;

import java.util.Random;

public class Practica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Números aleatorios para J1 y J2, del 1 al 5. Si la suma de los números
        es menor de 7, gana el J1, si es superior, gana el J2. Si la suma es 7, se 
        repite la ronda. Gana el mejor de 5.*/

        //Declaro e inicializo las variables que utilizaré durante el programa.
        final int VICTORIA = 3;
        int numeroJ1;
        int numeroJ2;
        int puntuacionInicialJ1 = 0;
        int puntuacionInicialJ2 = 0;
        int contadorRondasJugadas = 1;

        Random entrada = new Random();

        //Inicio el bucle que hará las rondas con el número generado al azar.
        do {
            //Genero para cada jugador un número al azar entre 1 y 5.
            numeroJ1 = entrada.nextInt(5) + 1;
            numeroJ2 = entrada.nextInt(5) + 1;
            //Muestro por pantalla los números sacados por cada jugador.
            System.out.println("Ronda " + contadorRondasJugadas);
            System.out.println("Jugador 1 saca " + numeroJ1 + ".\n"
                    + "Jugador 2 saca " + numeroJ2 + ".\n");
            /*Si la suma de ambos números es inferior a 7, gana el Jugador 1.
            Si la suma de ambos números es superior a 7, gana el Jugador 2.
            Si la suma de ambos números es 7, no cuantifica para cerrar el bucle.*/
            if ((numeroJ1 + numeroJ2) < 7) {
                puntuacionInicialJ1++;
                contadorRondasJugadas++;
                System.out.println("Gana la ronda J1");
            } else if ((numeroJ1 + numeroJ2) > 7) {
                puntuacionInicialJ2++;
                System.out.println("Gana la ronda J2");
            }
            //Cierro el bucle cuando uno de los dos jugadores llegue a 3 victorias.
        } while (puntuacionInicialJ1 != VICTORIA && puntuacionInicialJ2 != VICTORIA);
        //Muestro por pantalla el Jugador que haya ganado la partida, con un marcador general.
        if (puntuacionInicialJ1 == VICTORIA) {
            System.out.println("El Jugador 1 ha ganado " + puntuacionInicialJ1 + " a "
                    + puntuacionInicialJ2);
        } else {
            System.out.println("El Jugador 2 ha ganado " + puntuacionInicialJ2 + " a "
                    + puntuacionInicialJ1);
        }

    }

}
