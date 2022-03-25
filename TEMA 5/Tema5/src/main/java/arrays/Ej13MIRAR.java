package arrays;

import java.lang.reflect.Array;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Gabriel
 */
public class Ej13MIRAR {

    /**
     * @param args the command line arguments
     */
    /*Escribir un programa que lea números enteros entre 1 y 20 desde teclado. Se debe generar un histograma con las frecuencias de cada entero en la secuencia.
    Para representar las barras del histograma hay que utilizar secuencias del carácter ‘*’. El programa finaliza al introducir un cero.
    Por ejemplo, la secuencia: 1, 1, 20, 1, 2, 20, 3, 3, 3, 4, 4, 4, 5, 3 generaría la siguiente salida:
    1: ***
    2: *
    3: ****
    4: ***
    5:
    6:
    7:
    …
    20:**
     */
    public static void main(String[] args) {
        //Declaro array (histograma) de 20 posiciones (0-19).
        String[] histograma = new String[20];
        
        //Recorro todo el array y guardo "", para que no imprima null.
        for (int i = 0; i < histograma.length; i++) {
            histograma[i] = "";            
        }

        Scanner entrada = new Scanner(System.in);

        //Variable que controla el bucle, hasta que se teclee 0.
        boolean esCero = false;

        //Bucle que solicita números.
        do {
            //Declaración e inicialización de la variable con método pedirDatos()
            int numero = pedirDatos();
            //Condición a cumplir si se teclea un número diferente a 0, que guarda los asteriscos.
            if (numero != 0) {
                //Acceso a la posición real del array. Ej.: 4 --> 3.
                histograma[numero - 1] += "*";
            } else {
                esCero = true;
            }
        } while (!esCero);
        imprimirArray(histograma);
    }

    //Método que imprime array pasado por parámetro.
    private static void imprimirArray(String[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.println("Número " + (i+1) + ": " + array[i]);
        }
    }

    //Método que solicite número y controle que sea del 1 al 20.
    private static int pedirDatos() {
        Scanner entrada = new Scanner(System.in);
        int numeroIntroducido;
        boolean estaEntreValores = false;
        do {
            //Pedimos
            System.out.println("Introduzca un número del 1 al 20. Pulse 0 para finalizar.");
            numeroIntroducido = entrada.nextInt();

            //Preguntamos
            if (numeroIntroducido <= 20 && numeroIntroducido >= 0) {
                estaEntreValores = true;
            }
        } while (!estaEntreValores);
        return numeroIntroducido;
    }

}
